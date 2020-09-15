package org.alexrosl.spring.webscraper.entity

import org.springframework.security.core.GrantedAuthority
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

enum class Role : GrantedAuthority {
    ROLE_USER;

    override fun getAuthority(): String {
        return name
    }
}