package school.iu.oauth

import java.security.Principal

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    @RequestMapping("/user/me")
    Principal user(Principal principal) {
        principal
    }
}