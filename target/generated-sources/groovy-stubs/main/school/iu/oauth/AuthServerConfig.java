package school.iu.oauth;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.net.*;
import groovy.lang.*;
import groovy.util.*;

@org.springframework.context.annotation.Configuration() @org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer() public class AuthServerConfig
  extends org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter  implements
    groovy.lang.GroovyObject {
;
public AuthServerConfig
(org.springframework.security.authentication.AuthenticationManager authenticationManager) {}
@groovy.transform.Generated() @groovy.transform.Internal() @java.beans.Transient() public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
@groovy.transform.Generated() @groovy.transform.Internal() public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder getPasswordEncoder() { return (org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder)null;}
public  void setPasswordEncoder(org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder value) { }
public  org.springframework.security.authentication.AuthenticationManager getAuthenticationManager() { return (org.springframework.security.authentication.AuthenticationManager)null;}
public  void setAuthenticationManager(org.springframework.security.authentication.AuthenticationManager value) { }
@java.lang.Override() public  void configure(org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer oauthServer)throws java.lang.Exception { }
@java.lang.Override() public  void configure(org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer clients)throws java.lang.Exception { }
@java.lang.Override() public  void configure(org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer endpoints) { }
@org.springframework.context.annotation.Bean() public  org.springframework.security.oauth2.provider.token.TokenStore tokenStore() { return (org.springframework.security.oauth2.provider.token.TokenStore)null;}
@org.springframework.context.annotation.Bean() public  org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter accessTokenConverter() { return (org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter)null;}
@org.springframework.context.annotation.Bean() @org.springframework.context.annotation.Primary() public  org.springframework.security.oauth2.provider.token.DefaultTokenServices tokenServices() { return (org.springframework.security.oauth2.provider.token.DefaultTokenServices)null;}
}
