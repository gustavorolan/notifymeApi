package com.notfyme.api.mapper

import com.notfyme.api.controller.dto.request.post.EmpresaRequest
import com.notfyme.api.domain.EmpresaEntity

fun EmpresaRequest.toEntity() = EmpresaEntity(nome=nome, cnpj = cnpj, password = password)
