package com.notfyme.api.service

import com.notfyme.api.controller.dto.request.AplicativoRequest
import com.notfyme.api.controller.dto.response.AplicativoResponse
import com.notfyme.api.controller.dto.request.PageRequest
import org.springframework.data.domain.Page

interface AplicativoService {
    fun adicionar(aplicativoRequest: AplicativoRequest): Long
    fun remover(aplicativoId: Long)
    fun obter(aplicativoId: Long): AplicativoResponse
    fun obterPage(pageRequest: PageRequest): Page<AplicativoResponse>
}
