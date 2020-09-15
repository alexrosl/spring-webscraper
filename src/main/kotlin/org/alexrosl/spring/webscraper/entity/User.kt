package org.alexrosl.spring.webscraper.entity

import org.hibernate.annotations.BatchSize
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import javax.persistence.CollectionTable
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "users")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
data class User (

    @Id
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @Column(name = "id")
    val id: Int? = null,

    @Column(name = "username")
    val userName: String? = null,

    @Column(name = "password")
    val password: String? = null,

    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = [JoinColumn(name = "user_id")])
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 200)
    val roles: Collection<Role>? = null

)