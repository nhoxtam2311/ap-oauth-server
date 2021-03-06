package school.iu.oauth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.DefaultTokenServices
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore


@Configuration
@EnableAuthorizationServer
class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	BCryptPasswordEncoder passwordEncoder
	@Override
	void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()")
	}
	@Override
	void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("myclient1").secret(passwordEncoder.encode("mysecret1"))
				.authorizedGrantTypes("authorization_code", "client_credentials", "password", "refresh_token").scopes("user_info")
				.autoApprove(true)
				.redirectUris("http://localhost:8081/login", "http://localhost:8081")
				.accessTokenValiditySeconds(3600).and().withClient("myclient2")
				.secret(passwordEncoder.encode("mysecret2")).authorizedGrantTypes("password").scopes("internal")
				.accessTokenValiditySeconds(3600)
	}
	AuthServerConfig(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager
	}
	AuthenticationManager authenticationManager
	@Override
	void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		endpoints.authenticationManager(authenticationManager).accessTokenConverter(accessTokenConverter())
				.tokenStore(tokenStore())
	}
	@Bean
	TokenStore tokenStore() {
		new JwtTokenStore(accessTokenConverter())
	}
	@Bean
	JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter()
		converter.setSigningKey("jwtkey")
		converter
	}
	@Bean
	@Primary
	DefaultTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices()
		defaultTokenServices.setTokenStore(tokenStore())
		defaultTokenServices.setSupportRefreshToken true
		defaultTokenServices
	}
}
