package com.notfyme.api.mapper

import com.notfyme.api.controller.dto.request.post.AplicativoRequest
import com.notfyme.api.controller.dto.response.AplicativoResponse
import com.notfyme.api.domain.AplicativoEntity
import com.notfyme.api.domain.EmpresaEntity

fun AplicativoRequest.toEntity(empresaEntity: EmpresaEntity) = AplicativoEntity(nome = nome, empresaEntity = empresaEntity, apiKey = apiKey)

fun AplicativoEntity.toResponse() = AplicativoResponse(id = id!!, nome = nome)