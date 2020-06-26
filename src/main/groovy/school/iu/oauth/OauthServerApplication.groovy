package school.iu.oauth

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer

@SpringBootApplication
@EnableResourceServer
class OauthServerApplication {

	static void main(String[] args) {
		SpringApplication.run(OauthServerApplication, args)
	}

}
