package com.kotlin.controller

import com.kotlin.dto.BoardDTO
import com.kotlin.repository.BoardRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardApiController(
    private val boardRepository: BoardRepository
) {

    @GetMapping("/board")
    fun getArticles(@PageableDefault(size = 5) pageable: Pageable): Page<BoardDTO> {
        println("요청이 오긴 옴?")
        return boardRepository.findAll(pageable).map { board -> board.toDTO() }
    }


    @PostMapping("/board/write")
    fun writeArticle(@RequestBody boardDTO: BoardDTO): ResponseEntity<Any> {
        val board = boardDTO.toEntity()
        boardRepository.save(board)
        return ResponseEntity.ok().build()
    }

}