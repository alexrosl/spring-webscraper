package org.alexrosl.spring.webscraper.dto

import java.util.*

data class InfoRecordDTO(
    val author: String?,
    val link: String?,
    val text: String?,
    val datetime: Date?,
    val created: Date?
)