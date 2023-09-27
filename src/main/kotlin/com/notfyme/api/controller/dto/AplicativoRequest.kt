package com.notfyme.api.controller.dto

data class AplicativoRequest(
    val nome: String,

    val empresaId: Long,

    val apiKey: String,
)
