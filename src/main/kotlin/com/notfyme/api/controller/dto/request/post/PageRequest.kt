package com.notfyme.api.controller.dto.request.post

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

data class PageRequest(
    val page: Int? = 0,
    val linesPerPage: Int? = 10,
    val orderBy: String? = "id",
    val direction: Sort.Direction? = Sort.Direction.ASC
) {
    fun obter() = PageRequest.of(page!!, linesPerPage!!, sort())
    private fun sort() = Sort.by(direction!!, orderBy)
}