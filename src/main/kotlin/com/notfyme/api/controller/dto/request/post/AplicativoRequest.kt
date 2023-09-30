package com.notfyme.api.controller.dto.request.post

import jakarta.validation.constraints.NotBlank

data class AplicativoRequest(
    @field:NotBlank
    val nome: String,
    @field:NotBlank
    val apiKey: String,
)
