package org.alexrosl.spring.webscraper.service

import org.alexrosl.spring.webscraper.repository.UserRepository
import org.alexrosl.spring.webscraper.entity.User
import org.alexrosl.spring.webscraper.exception.NotFoundException
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import javax.transaction.Transactional
import org.springframework.security.core.userdetails.User as SpringUser

@Service
open class UserServiceImpl(
        private val userDao: UserRepository
) : UserService {

    @Transactional
    override fun findByUserName(userName: String): User? {
        return userDao.findByUserName(userName)
    }

    @Transactional
    override fun loadUserByUsername(userName: String): UserDetails {
        val user = userDao.findByUserName(userName)
                ?: throw NotFoundException("user with name $userName is not found")
        return SpringUser(user.userName, user.password, user.roles?.map { SimpleGrantedAuthority(it.name) })
    }
}
