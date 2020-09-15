package org.alexrosl.spring.webscraper.service

import org.alexrosl.spring.webscraper.entity.User
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService : UserDetailsService {
    fun findByUserName(userName: String): User?
}