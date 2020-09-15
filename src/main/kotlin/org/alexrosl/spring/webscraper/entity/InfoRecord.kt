package org.alexrosl.spring.webscraper.entity

import org.alexrosl.spring.webscraper.dto.InfoRecordDTO
import java.time.ZonedDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "all_info")
data class InfoRecord (

    @Id
    @Column(name = "id")
    val id: String? = null,

    @Column(name = "source")
    val source: String? = null,

    @Column(name = "author")
    val author: String? = null,

    @Column(name = "link")
    val link: String? = null,

    @Column(name = "text")
    val text: String? = null,

    @Column(name = "datetime")
    val datetime: ZonedDateTime? = ZonedDateTime.now(),

    @Column(name = "created")
    val created: ZonedDateTime? = ZonedDateTime.now()
)

fun InfoRecord.toDTO(): InfoRecordDTO {
    return InfoRecordDTO(
        author = this.source + "<br>" + this.author,
        link = this.link,
        text = this.text?.replace("\n", "<br>"),
        datetime = Date.from(this.datetime?.toInstant()),
        created = Date.from(this.created?.toInstant())
    )
}