package com.notfyme.api.controller.dto.request.post

data class EmpresaRequest(
    val nome: String,
    val cnpj: String,
    val password: String,
)
