package com.notfyme.api.service.impl

import com.notfyme.api.controller.dto.request.put.AplicativoAlterarRequest
import com.notfyme.api.controller.dto.request.post.AplicativoRequest
import com.notfyme.api.controller.dto.request.post.PageRequest
import com.notfyme.api.exception.EmpresaOuAplicativoNaoEncontradoException
import com.notfyme.api.mapper.toEntity
import com.notfyme.api.mapper.toResponse
import com.notfyme.api.repository.AplicativoRepository
import com.notfyme.api.security.EmpresaAutenticadaService
import com.notfyme.api.service.AplicativoService
import org.springframework.stereotype.Service

@Service
class AplicativoServiceImpl(
    private val empresaAutenticadaService: EmpresaAutenticadaService,
    private val aplicativoRepository: AplicativoRepository
) : AplicativoService {
    override fun alterar(idAplicativo: Long, aplicativoRequest: AplicativoAlterarRequest) {
        val aplicativoEntity = obterEntity(idAplicativo)
        val novoAplicativoEntity = aplicativoEntity.copy(
            nome = aplicativoRequest.nome.ifEmpty { aplicativoEntity.nome },
            apiKey = aplicativoRequest.apiKey.ifEmpty { aplicativoEntity.apiKey }
        )
        aplicativoRepository.save(novoAplicativoEntity);
    }

    override fun adicionar(aplicativoRequest: AplicativoRequest): Long {
        val empresaEntity = empresaAutenticadaService.empresaEntity

        val aplicativoEntity = aplicativoRequest.toEntity(empresaEntity)

        return aplicativoRepository.save(aplicativoEntity).id!!
    }

    override fun remover(aplicativoId: Long) {
        val aplicativoEntity = obterEntity(aplicativoId)

        aplicativoRepository.delete(aplicativoEntity)
    }

    override fun obter(aplicativoId: Long) = obterEntity(aplicativoId).toResponse()

    override fun obterPage(pageRequest: PageRequest) =
        aplicativoRepository.findByEmpresaEntityId(empresaAutenticadaService.getId(), pageRequest.obter())
            .map { it.toResponse() }


    override fun obterEntity(aplicativoId: Long) = aplicativoRepository.findByIdAndEmpresaEntityId(aplicativoId, empresaAutenticadaService.getId())
        .orElseThrow { EmpresaOuAplicativoNaoEncontradoException() }
}