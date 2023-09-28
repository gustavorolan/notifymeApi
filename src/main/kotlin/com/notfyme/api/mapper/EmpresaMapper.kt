package com.notfyme.api.mapper

import com.notfyme.api.controller.dto.request.EmpresaRequest
import com.notfyme.api.domain.EmpresaEntity

fun EmpresaRequest.toEntity() = EmpresaEntity(nome=nome, cnpj = cnpj, password = password)
