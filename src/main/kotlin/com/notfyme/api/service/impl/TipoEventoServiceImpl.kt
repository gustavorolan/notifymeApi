package com.notfyme.api.service.impl

import com.notfyme.api.controller.dto.request.post.PageRequest
import com.notfyme.api.controller.dto.request.post.TipoEventoRequest
import com.notfyme.api.controller.dto.request.put.TipoEventoAlterarRequest
import com.notfyme.api.controller.dto.response.TipoEventoResponse
import com.notfyme.api.exception.EmpresaTipoEventoEncontradaException
import com.notfyme.api.mapper.toEntity
import com.notfyme.api.mapper.toResponse
import com.notfyme.api.repository.TipoEventoRepository
import com.notfyme.api.security.EmpresaAutenticadaService
import com.notfyme.api.service.TipoEventoService
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class TipoEventoServiceImpl(
    private val empresaAutenticadaService: EmpresaAutenticadaService,
    private val tipoEventoRepository: TipoEventoRepository
) : TipoEventoService {
    override fun alterar(tipoEventoId: Long, tipoEventoRequest: TipoEventoAlterarRequest) {
        val entity = obterEntity(tipoEventoId)
        val novaEntity = entity.copy(
            nome = tipoEventoRequest.nome.ifEmpty { entity.nome },
            ativo = tipoEventoRequest.ativo
        )
        tipoEventoRepository.save(novaEntity)
    }

    override fun adicionar(tipoEventoRequest: TipoEventoRequest): Long {
        val empresaEntity = empresaAutenticadaService.empresaEntity
        val tipoeEventoEntity = tipoEventoRequest.toEntity(empresaEntity)
        return tipoEventoRepository.save(tipoeEventoEntity).id!!
    }

    override fun remover(tipoEventoId: Long) {
        val entity = obterEntity(tipoEventoId)
        tipoEventoRepository.delete(entity)
    }

    override fun obter(tipoEventoId: Long): TipoEventoResponse = obterEntity(tipoEventoId)
        .toResponse()

    override fun obterPage(pageRequest: PageRequest): Page<TipoEventoResponse> =
        tipoEventoRepository.findByEmpresaEntityId(empresaAutenticadaService.getId(), pageRequest.obter())
            .map { it.toResponse() }

    private fun obterEntity(id: Long) =
        tipoEventoRepository.findByIdAndEmpresaEntityId(id, empresaAutenticadaService.getId())
            .orElseThrow { EmpresaTipoEventoEncontradaException() }
}