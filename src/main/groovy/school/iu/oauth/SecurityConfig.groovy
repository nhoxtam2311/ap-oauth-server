package school.iu.oauth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.core.env.Environment
import org.springframework.ldap.core.support.LdapContextSource
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.LdapShaPasswordEncoder
import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator

@EnableWebSecurity
@SuppressWarnings("deprecation")
@Configuration
@Order(1)
class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	Environment env
	@Bean
	LdapContextSource contextSource() {
		LdapContextSource contextSource = new LdapContextSource()
		contextSource.setUrl(env.getRequiredProperty("ldap.url"))
		contextSource.setBase(env.getRequiredProperty("ldap.partitionSuffix"))
		contextSource
	}
	@Override
	void configure(HttpSecurity http) throws Exception { // @formatter:off
		http.
		requestMatchers().antMatchers("/login", "/oauth/authorize").and().authorizeRequests().anyRequest()
				.authenticated().and().formLogin().loginPage("/login").permitAll()
	} // @formatter:on
	@Override
	void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.ldapAuthentication().userDnPatterns("uid={0},ou=Users").userSearchFilter("(uid={0})")
				.userSearchBase("dc=example,dc=com").ldapAuthoritiesPopulator(ldapAuthoritiesPopulator())
				.contextSource(contextSource()).passwordCompare().passwordEncoder(new LdapShaPasswordEncoder())
				.passwordAttribute("userPassword")
	}
	@Bean
	LdapAuthoritiesPopulator ldapAuthoritiesPopulator() {
		DefaultLdapAuthoritiesPopulator ldapAuthoritiesPopulator = new DefaultLdapAuthoritiesPopulator(contextSource(),
				"ou=Groups,dc=example,dc=com")
		ldapAuthoritiesPopulator.setSearchSubtree(true)
		ldapAuthoritiesPopulator.setGroupSearchFilter("(member={0})")
		ldapAuthoritiesPopulator
	}
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		new BCryptPasswordEncoder()
	}
	@Bean
	@Override
	AuthenticationManager authenticationManagerBean() throws Exception {
		super.authenticationManagerBean()
	}
}
