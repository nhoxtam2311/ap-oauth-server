package school.iu.oauth

import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@EnableWebMvc
@Configuration
class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login")
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE)
    }
}
