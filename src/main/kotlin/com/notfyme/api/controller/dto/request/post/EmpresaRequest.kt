package com.notfyme.api.controller.dto.request.post

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class EmpresaRequest(
    @field:NotBlank
    val nome: String,
    @field:NotBlank
    val cnpj: String,
    @field:NotBlank @field:Size(min= 6, max = 50)
    val password: String,
)
