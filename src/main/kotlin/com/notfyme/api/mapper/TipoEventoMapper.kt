package com.notfyme.api.mapper

import com.notfyme.api.controller.dto.request.post.TipoEventoRequest
import com.notfyme.api.controller.dto.response.TipoEventoResponse
import com.notfyme.api.domain.EmpresaEntity
import com.notfyme.api.domain.TipoEventoEntity

fun TipoEventoRequest.toEntity(empresaEntity: EmpresaEntity, externalId : String) =
    TipoEventoEntity(nome = nome, ativo = ativo, empresaEntity = empresaEntity, externalId = externalId)

fun TipoEventoEntity.toResponse() = TipoEventoResponse(id = id!!, nome = nome)