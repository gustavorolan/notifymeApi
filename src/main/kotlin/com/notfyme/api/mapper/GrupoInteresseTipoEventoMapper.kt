package com.notfyme.api.mapper

import com.notfyme.api.controller.dto.request.post.GrupoInteresseTipoEventoRequest
import com.notfyme.api.controller.dto.response.GrupoInteresseTipoEventoResponse
import com.notfyme.api.domain.GrupoInteresseEntity
import com.notfyme.api.domain.GrupoInteresseTipoEventoEntity
import com.notfyme.api.domain.TipoEventoEntity

fun GrupoInteresseTipoEventoRequest.toEntity(grupoInteresseEntity: GrupoInteresseEntity, tipoEventoEntity: TipoEventoEntity) =
    GrupoInteresseTipoEventoEntity(grupoInteresseEntity = grupoInteresseEntity, tipoEventoEntity = tipoEventoEntity)

fun GrupoInteresseTipoEventoEntity.toResponse() =
    GrupoInteresseTipoEventoResponse(nomeGrupoIntesse = grupoInteresseEntity.nome, nomeTipoEvento = tipoEventoEntity.nome)