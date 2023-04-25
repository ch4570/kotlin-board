package com.kotlin.entity

import com.kotlin.dto.BoardDTO
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Board (

    @Id @GeneratedValue
    @Column(name = "ARTICLE_NO")
    val id: Long? = null,

    @Column(name = "ARTICLE_TITLE", length = 100)
    val title: String,

    @Column(name = "ARTICLE_CONTENT", columnDefinition = "TEXT")
    val content: String,

        ): BaseEntity() {


    fun toDTO() = BoardDTO(
        id = id,
        title = title,
        content = content,
        author = createdBy,
        createdDate = regDate
    )
}