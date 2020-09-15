package org.alexrosl.spring.webscraper.repository

import org.alexrosl.spring.webscraper.entity.User

interface UserRepository {
    fun findByUserName(userName: String): User?
}