package com.notfyme.api.controller.dto.request.post

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class TipoEventoRequest(
        @field:NotBlank val nome: String,

        val ativo: Boolean = true,
)