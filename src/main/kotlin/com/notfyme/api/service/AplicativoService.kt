package com.notfyme.api.service

import com.notfyme.api.controller.dto.request.put.AplicativoAlterarRequest
import com.notfyme.api.controller.dto.request.post.AplicativoRequest
import com.notfyme.api.controller.dto.request.post.PageRequest
import com.notfyme.api.controller.dto.response.AplicativoResponse
import com.notfyme.api.domain.AplicativoEntity
import org.springframework.data.domain.Page

interface AplicativoService {
    fun alterar(idAplicativo: Long, aplicativoRequest: AplicativoAlterarRequest)
    fun adicionar(aplicativoRequest: AplicativoRequest): Long
    fun remover(aplicativoId: Long)
    fun obter(aplicativoId: Long): AplicativoResponse
    fun obterPage(pageRequest: PageRequest): Page<AplicativoResponse>
    fun obterEntity(aplicativoId: Long): AplicativoEntity?
}
