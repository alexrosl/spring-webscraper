package org.alexrosl.spring.webscraper

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class WebscraperApp {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(WebscraperApp::class.java)
        }
    }
}