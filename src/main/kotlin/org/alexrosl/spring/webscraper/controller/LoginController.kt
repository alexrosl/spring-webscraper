package org.alexrosl.spring.webscraper.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
open class LoginController {

    @GetMapping("/login")
    fun showLoginPage(): String {
        return "login"
    }

    @GetMapping("/access-denied")
    fun showAccessDeniedPage(): String {
        return "access-denied"
    }
}