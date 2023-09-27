package com.notfyme.api.service

import com.notfyme.api.controller.dto.AplicativoRequest
import com.notfyme.api.controller.dto.AplicativoResponse
import org.springframework.data.domain.Page

interface AplicativoService {
    fun adicionar(aplicativoRequest: AplicativoRequest)
    fun remover(aplicativoId: Long, empresaId: Long)
    fun obter(aplicativoId: Long, empresaId: Long): AplicativoResponse
    fun obterPage(empresaId: Long, page: Int): Page<AplicativoResponse>
}
