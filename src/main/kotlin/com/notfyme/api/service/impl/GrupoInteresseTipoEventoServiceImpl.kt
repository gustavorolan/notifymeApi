package com.notfyme.api.service.impl

import com.notfyme.api.controller.dto.request.post.GrupoInteresseTipoEventoRequest
import com.notfyme.api.controller.dto.request.post.PageRequest
import com.notfyme.api.controller.dto.response.GrupoInteresseTipoEventoResponse
import com.notfyme.api.exception.GrupoInteresseTipoEventoNaoEncontradoException
import com.notfyme.api.mapper.toEntity
import com.notfyme.api.mapper.toResponse
import com.notfyme.api.repository.GrupoInteresseTipoEventoRepository
import com.notfyme.api.security.EmpresaAutenticadaService
import com.notfyme.api.service.GrupoInteresseService
import com.notfyme.api.service.GrupoInteresseTipoEventoService
import com.notfyme.api.service.TipoEventoService
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class GrupoInteresseTipoEventoServiceImpl(
    private val empresaAutenticadaService: EmpresaAutenticadaService,
    private val grupoInteresseTipoEventoRepository: GrupoInteresseTipoEventoRepository,
    private val grupoInteresseService: GrupoInteresseService,
    private val tipoEventoService: TipoEventoService
) : GrupoInteresseTipoEventoService {
    override fun obter(grupoInteresseId: Long): GrupoInteresseTipoEventoResponse =
        obterEntity(grupoInteresseId).toResponse()

    override fun obterPage(pageRequest: PageRequest): Page<GrupoInteresseTipoEventoResponse> =
        grupoInteresseTipoEventoRepository.findByGrupoInteresseEntityEmpresaEntityId(empresaAutenticadaService.getId(), pageRequest.obter())
            .map { it.toResponse() }

    override fun adicionar(grupoInteresseTipoEventoRequest: GrupoInteresseTipoEventoRequest): Long {
        val (grupoInteresseId, tipoEventoId) = grupoInteresseTipoEventoRequest
        val grupoInteresseEntity = grupoInteresseService.obterEntity(grupoInteresseId)
        val tipoEventoEntity = tipoEventoService.obterEntity(tipoEventoId)

        val grupoInteresseTipoEventoEntity = grupoInteresseTipoEventoRequest.toEntity(grupoInteresseEntity, tipoEventoEntity)

        return grupoInteresseTipoEventoRepository.save(grupoInteresseTipoEventoEntity).id!!
    }

    override fun remover(grupoInteresseTipoEventoId: Long) {
        val grupoInteresseTipoEventoEntity = obterEntity(grupoInteresseTipoEventoId)
        grupoInteresseTipoEventoRepository.delete(grupoInteresseTipoEventoEntity)
    }

    override fun obterEntity(id: Long) =
        grupoInteresseTipoEventoRepository.findByIdAndGrupoInteresseEntityEmpresaEntityId(id, empresaAutenticadaService.getId())
            .orElseThrow { GrupoInteresseTipoEventoNaoEncontradoException() }
}