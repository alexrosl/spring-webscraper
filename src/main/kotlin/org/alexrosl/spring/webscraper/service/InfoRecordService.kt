package org.alexrosl.spring.webscraper.service

import org.alexrosl.spring.webscraper.entity.InfoRecord

interface InfoRecordService {
    fun findAll(): List<InfoRecord?>?
}