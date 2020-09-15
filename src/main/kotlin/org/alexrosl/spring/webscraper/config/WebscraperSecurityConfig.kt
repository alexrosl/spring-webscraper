package org.alexrosl.spring.webscraper.config

import org.alexrosl.spring.webscraper.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
open class WebscraperSecurityConfig(
        private val userService: UserService,
        private val customAuthenticationSuccessHandler: CustomAuthenticationSuccessHandler
) : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(authenticationProvider())
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .antMatchers("/**").hasAnyRole("USER")
                .antMatchers("/resources/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticate-user")
                .successHandler(customAuthenticationSuccessHandler)
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied")
    }

    @Bean
    open fun passwordEncoder(): BCryptPasswordEncoder? {
        return BCryptPasswordEncoder()
    }

    //authenticationProvider bean definition
    @Bean
    open fun authenticationProvider(): DaoAuthenticationProvider? {
        val auth = DaoAuthenticationProvider()
        auth.setUserDetailsService(userService) //set the custom user details service
        auth.setPasswordEncoder(passwordEncoder()) //set the password encoder - bcrypt
        return auth
    }
}