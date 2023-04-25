package com.kotlin.dto

import com.kotlin.entity.Board
import java.time.LocalDateTime

class BoardDTO(
    var id: Long?,
    var title: String,
    var content: String,
    var author: String?,
    var createdDate: LocalDateTime?
) {
    fun toEntity() = Board(title = title, content = content)
}