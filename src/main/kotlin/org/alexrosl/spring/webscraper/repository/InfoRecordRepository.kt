package org.alexrosl.spring.webscraper.repository

import org.alexrosl.spring.webscraper.entity.InfoRecord

interface InfoRecordRepository {
    fun findAll(): List<InfoRecord?>?
}