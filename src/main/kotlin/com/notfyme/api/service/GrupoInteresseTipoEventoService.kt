package com.notfyme.api.service

import com.notfyme.api.controller.dto.request.post.GrupoInteresseTipoEventoRequest
import com.notfyme.api.controller.dto.request.post.PageRequest
import com.notfyme.api.controller.dto.response.GrupoInteresseTipoEventoResponse
import com.notfyme.api.domain.GrupoInteresseTipoEventoEntity
import org.springframework.data.domain.Page

interface GrupoInteresseTipoEventoService {
    fun obter(grupoInteresseId: Long): GrupoInteresseTipoEventoResponse
    fun obterPage(pageRequest: PageRequest): Page<GrupoInteresseTipoEventoResponse>
    fun adicionar(grupoInteresseTipoEventoRequest: GrupoInteresseTipoEventoRequest): Long
    fun remover(grupoInteresseTipoEventoId: Long)
    fun obterEntity(id: Long): GrupoInteresseTipoEventoEntity?
}
