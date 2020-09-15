package org.alexrosl.spring.webscraper.repository

import org.alexrosl.spring.webscraper.entity.InfoRecord
import org.hibernate.Session
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
open class InfoRecordRepositoryImpl(
        private val entityManager: EntityManager
) : InfoRecordRepository {
    override fun findAll(): List<InfoRecord?>? {
        val session = entityManager.unwrap(Session::class.java)
        val query = session.createQuery("SELECT u FROM InfoRecord u", InfoRecord::class.java)
        return query.resultList
    }
}