package com.notfyme.api.mapper

import com.notfyme.api.controller.dto.request.post.GrupoInteresseRequest
import com.notfyme.api.controller.dto.response.GrupoInteresseResponse
import com.notfyme.api.domain.AplicativoEntity
import com.notfyme.api.domain.EmpresaEntity
import com.notfyme.api.domain.GrupoInteresseEntity

fun GrupoInteresseRequest.toEntity(empresaEntity: EmpresaEntity, aplicativoEntity: AplicativoEntity) =
    GrupoInteresseEntity(nome = nome, empresaEntity = empresaEntity, aplicativoEntity = aplicativoEntity)

fun GrupoInteresseEntity.toResponse() = GrupoInteresseResponse(id = id!!, nome = nome)