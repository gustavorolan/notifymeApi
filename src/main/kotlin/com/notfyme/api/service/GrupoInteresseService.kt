package com.notfyme.api.service

import com.notfyme.api.controller.dto.request.GrupoInteresseRequest
import com.notfyme.api.controller.dto.request.PageRequest
import com.notfyme.api.controller.dto.response.GrupoInteresseResponse
import com.notfyme.api.domain.GrupoInteresseEntity
import org.springframework.data.domain.Page

interface GrupoInteresseService {
    fun adicionar(grupoInteresseRequest: GrupoInteresseRequest): Long
    fun remover(grupoInteresseId: Long)
    fun obter(grupoInteresseId: Long): GrupoInteresseResponse
    fun obterPage(pageRequest: PageRequest): Page<GrupoInteresseResponse>
    fun obterPage(aplicativoId: Long, pageRequest: PageRequest): Page<GrupoInteresseResponse>
}