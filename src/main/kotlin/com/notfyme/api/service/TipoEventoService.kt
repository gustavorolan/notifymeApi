package com.notfyme.api.service

import com.notfyme.api.controller.dto.request.post.PageRequest
import com.notfyme.api.controller.dto.request.post.TipoEventoRequest
import com.notfyme.api.controller.dto.request.put.TipoEventoAlterarRequest
import com.notfyme.api.controller.dto.response.TipoEventoResponse
import com.notfyme.api.domain.TipoEventoEntity
import org.springframework.data.domain.Page

interface TipoEventoService {
    fun alterar(tipoEventoId: Long, tipoEventoRequest: TipoEventoAlterarRequest)
    fun adicionar(tipoEventoRequest: TipoEventoRequest): Long
    fun remover(tipoEventoId: Long)
    fun obter(tipoEventoId: Long): TipoEventoResponse
    fun obterPage(pageRequest: PageRequest): Page<TipoEventoResponse>
    fun obterEntity(id: Long): TipoEventoEntity
}
