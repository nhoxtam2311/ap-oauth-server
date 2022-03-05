package school.iu.oauth;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.net.*;
import groovy.lang.*;
import groovy.util.*;

@org.springframework.security.config.annotation.web.configuration.EnableWebSecurity() @java.lang.SuppressWarnings(value="deprecation") @org.springframework.context.annotation.Configuration() @org.springframework.core.annotation.Order(value=1) public class SecurityConfig
  extends org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter  implements
    groovy.lang.GroovyObject {
;
@groovy.transform.Generated() @groovy.transform.Internal() @java.beans.Transient() public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
@groovy.transform.Generated() @groovy.transform.Internal() public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  org.springframework.core.env.Environment getEnv() { return (org.springframework.core.env.Environment)null;}
public  void setEnv(org.springframework.core.env.Environment value) { }
@org.springframework.context.annotation.Bean() public  org.springframework.ldap.core.support.LdapContextSource contextSource() { return (org.springframework.ldap.core.support.LdapContextSource)null;}
@java.lang.Override() public  void configure(org.springframework.security.config.annotation.web.builders.HttpSecurity http)throws java.lang.Exception { }
@java.lang.Override() public  void configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder auth)throws java.lang.Exception { }
@org.springframework.context.annotation.Bean() public  org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator ldapAuthoritiesPopulator() { return (org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator)null;}
@org.springframework.context.annotation.Bean() public  org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder passwordEncoder() { return (org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder)null;}
@org.springframework.context.annotation.Bean() @java.lang.Override() public  org.springframework.security.authentication.AuthenticationManager authenticationManagerBean()throws java.lang.Exception { return (org.springframework.security.authentication.AuthenticationManager)null;}
}
