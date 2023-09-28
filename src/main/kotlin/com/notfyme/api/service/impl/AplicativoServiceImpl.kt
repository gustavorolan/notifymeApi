package com.notfyme.api.service.impl

import com.notfyme.api.controller.dto.request.AplicativoRequest
import com.notfyme.api.controller.dto.request.PageRequest
import com.notfyme.api.exception.EmpresaNaoEncontradaException
import com.notfyme.api.exception.EmpresaOuAplicativoNaoEncontradoException
import com.notfyme.api.mapper.toEntity
import com.notfyme.api.mapper.toResponse
import com.notfyme.api.repository.AplicativoRepository
import com.notfyme.api.security.EmpresaAutenticadaService
import com.notfyme.api.service.AplicativoService
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class AplicativoServiceImpl(
    private val empresaAutenticadaService: EmpresaAutenticadaService,
    private val aplicativoRepository: AplicativoRepository
) : AplicativoService {

    override fun adicionar(aplicativoRequest: AplicativoRequest): Long {
        val empresaEntity = empresaAutenticadaService.empresaEntity

        val aplicativoEntity = aplicativoRequest.toEntity(empresaEntity)

        return aplicativoRepository.save(aplicativoEntity).id!!
    }

    override fun remover(aplicativoId: Long) {
        val aplicativoEntity = aplicativoRepository.findByIdAndEmpresaEntityId(aplicativoId, empresaAutenticadaService.getId())
            .orElseThrow { EmpresaOuAplicativoNaoEncontradoException() }

        aplicativoRepository.delete(aplicativoEntity)
    }

    override fun obter(aplicativoId: Long) =
        aplicativoRepository.findByIdAndEmpresaEntityId(aplicativoId, empresaAutenticadaService.getId())
            .orElseThrow { EmpresaOuAplicativoNaoEncontradoException() }
            .toResponse()

    override fun obterPage(pageRequest: PageRequest) =
        aplicativoRepository.findByEmpresaEntityId(empresaAutenticadaService.getId(), pageRequest.obter())
            .map { it.toResponse() }
}