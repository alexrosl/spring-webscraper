package org.alexrosl.spring.webscraper.repository

import org.alexrosl.spring.webscraper.entity.User
import org.hibernate.Session
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
open class UserRepositoryImpl(
        private val entityManager: EntityManager
) : UserRepository {
    override fun findByUserName(userName: String): User? {
        val session = entityManager.unwrap(Session::class.java)
        val query = session.createQuery("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.userName=:uName", User::class.java)
        query.setParameter("uName", userName)
        return query.singleResult
    }
}