package org.alexrosl.spring.webscraper.service

import org.alexrosl.spring.webscraper.entity.InfoRecord
import org.alexrosl.spring.webscraper.exception.NotFoundException
import org.alexrosl.spring.webscraper.repository.InfoRecordRepository
import org.springframework.stereotype.Service

@Service
class InfoRecordServiceImpl(
        private val infoRecordRepository: InfoRecordRepository
) : InfoRecordService {
    override fun findAll(): List<InfoRecord?>? {
        return infoRecordRepository.findAll() ?: throw NotFoundException("info records not found")
    }
}