package com.notfyme.api.service

import com.notfyme.api.controller.dto.AplicativoRequest
import com.notfyme.api.controller.dto.AplicativoResponse
import com.notfyme.api.controller.dto.PageRequest
import org.springframework.data.domain.Page

interface AplicativoService {
    fun adicionar(aplicativoRequest: AplicativoRequest): Long
    fun remover(aplicativoId: Long)
    fun obter(aplicativoId: Long): AplicativoResponse
    fun obterPage(pageRequest: PageRequest): Page<AplicativoResponse>
}
