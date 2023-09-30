package com.notfyme.api.controller.dto.request.post

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

data class GrupoInteresseTipoEventoRequest(
    @field:Min(1) @field:Max(Long.MAX_VALUE) val grupoInteresseId: Long,
    @field:Min(1) @field:Max(Long.MAX_VALUE) val tipoEventoId: Long
)
