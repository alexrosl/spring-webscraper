package org.alexrosl.spring.webscraper.config

import org.alexrosl.spring.webscraper.entity.User
import org.alexrosl.spring.webscraper.service.UserService
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
open class CustomAuthenticationSuccessHandler(
        private val userService: UserService
) : AuthenticationSuccessHandler {



    override fun onAuthenticationSuccess(request: HttpServletRequest, response: HttpServletResponse, authentication: Authentication) {

        val theUser: User? = userService.findByUserName(authentication.name)

        // now place in the session
        request.session.setAttribute("user", theUser)

        // forward to home page
        response.sendRedirect(request.contextPath + "/list")
    }

}