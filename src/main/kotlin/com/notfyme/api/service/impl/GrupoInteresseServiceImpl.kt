package com.notfyme.api.service.impl

import com.notfyme.api.controller.dto.request.put.GrupoInteresseAlterarRequest
import com.notfyme.api.controller.dto.request.post.GrupoInteresseRequest
import com.notfyme.api.controller.dto.request.post.PageRequest
import com.notfyme.api.controller.dto.response.GrupoInteresseResponse
import com.notfyme.api.domain.GrupoInteresseEntity
import com.notfyme.api.exception.AplicativoNaoEncontradoException
import com.notfyme.api.exception.EmpresaOuGrupoInteresseNaoEncontradoException
import com.notfyme.api.mapper.toEntity
import com.notfyme.api.mapper.toResponse
import com.notfyme.api.repository.AplicativoRepository
import com.notfyme.api.repository.GrupoInteresseRepository
import com.notfyme.api.security.EmpresaAutenticadaService
import com.notfyme.api.service.GrupoInteresseService
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class GrupoInteresseServiceImpl(
    private val empresaAutenticadaService: EmpresaAutenticadaService,
    private val aplicativoRepository: AplicativoRepository,
    private val grupoInteresseRepository: GrupoInteresseRepository
) : GrupoInteresseService {
    override fun alterar(idGrupoInteresse: Long, grupoInteresseRequest: GrupoInteresseAlterarRequest) {
        val entity = obterEntity(idGrupoInteresse)
        val novaEntity = entity.copy(
            nome = grupoInteresseRequest.nome.ifEmpty { entity.nome }
        )
        grupoInteresseRepository.save(novaEntity)
    }

    override fun adicionar(grupoInteresseRequest: GrupoInteresseRequest): Long {
        val empresaEntity = empresaAutenticadaService.empresaEntity
        val aplicativoEntity = aplicativoRepository.findById(grupoInteresseRequest.aplicativoId)
            .orElseThrow { AplicativoNaoEncontradoException() }

        val grupoInteresseEntity = grupoInteresseRequest
            .toEntity(aplicativoEntity = aplicativoEntity, empresaEntity = empresaEntity)

        return grupoInteresseRepository.save(grupoInteresseEntity).id!!
    }

    override fun remover(grupoInteresseId: Long) {
        val grupoInteresseEntity = obterEntity(grupoInteresseId)

        grupoInteresseRepository.delete(grupoInteresseEntity)
    }

    override fun obter(grupoInteresseId: Long) = obterEntity(grupoInteresseId).toResponse()

    override fun obterPage(pageRequest: PageRequest): Page<GrupoInteresseResponse> =
        grupoInteresseRepository.findByEmpresaEntityId(empresaAutenticadaService.getId(), pageRequest.obter())
            .map { it.toResponse() }

    override fun obterPage(aplicativoId: Long, pageRequest: PageRequest): Page<GrupoInteresseResponse> =
        grupoInteresseRepository
            .findByEmpresaEntityIdAndAplicativoEntityId(empresaAutenticadaService.getId(), aplicativoId, pageRequest.obter())
            .map { it.toResponse() }

    override fun obterEntity(grupoInteresseId: Long): GrupoInteresseEntity =
        grupoInteresseRepository.findByIdAndEmpresaEntityId(grupoInteresseId, empresaAutenticadaService.getId())
            .orElseThrow { EmpresaOuGrupoInteresseNaoEncontradoException() }
}