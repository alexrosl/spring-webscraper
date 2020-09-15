package org.alexrosl.spring.webscraper.controller

import org.alexrosl.spring.webscraper.dto.InfoRecordDTO
import org.alexrosl.spring.webscraper.entity.toDTO
import org.alexrosl.spring.webscraper.service.InfoRecordService
import org.springframework.http.HttpRequest
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.ZoneOffset
import java.util.*

@Controller
class WebscraperController(
        private val infoRecordService: InfoRecordService
) {

    @GetMapping("/list")
    fun getDemoMessage(model: Model): String {
        val records = infoRecordService.findAll()
        val recordsDTO = records?.map {
            it?.toDTO()
        }
        model.addAttribute("order_column", 4)
        model.addAttribute("records", recordsDTO)
        return "record-list"
    }
}