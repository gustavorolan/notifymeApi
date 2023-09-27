package com.notfyme.api.service.impl

import com.notfyme.api.controller.dto.AplicativoRequest
import com.notfyme.api.exception.EmpresaNaoEncontradaException
import com.notfyme.api.mapper.toEntity
import com.notfyme.api.mapper.toResponse
import com.notfyme.api.repository.AplicativoRepository
import com.notfyme.api.repository.EmpresaRepository
import com.notfyme.api.service.AplicativoService
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class AplicativoServiceImpl(
    private val empresaRepository: EmpresaRepository,
    private val aplicativoRepository: AplicativoRepository
) : AplicativoService {

    companion object{
        private const val NUMERO_DE_ELEMENTOS_POR_PAGINA = 10
    }

    override fun adicionar(aplicativoRequest: AplicativoRequest) {
        val empresaEntity = empresaRepository.findById(aplicativoRequest.empresaId).orElseThrow { EmpresaNaoEncontradaException() }

        val aplicativoEntity = aplicativoRequest.toEntity(empresaEntity)

        aplicativoRepository.save(aplicativoEntity)
    }

    override fun remover(aplicativoId: Long, empresaId: Long) {
        val aplicativoEntity = aplicativoRepository.findByIdAndEmpresaEntityId(aplicativoId, empresaId)
            .orElseThrow { EmpresaNaoEncontradaException() }

        aplicativoRepository.delete(aplicativoEntity)
    }

    override fun obter(aplicativoId: Long, empresaId: Long) =
        aplicativoRepository.findByIdAndEmpresaEntityId(aplicativoId, empresaId)
            .orElseThrow { EmpresaNaoEncontradaException() }
            .toResponse()

    override fun obterPage(empresaId: Long, page:Int) =
        aplicativoRepository.findByEmpresaEntityId(empresaId, PageRequest.of(page, NUMERO_DE_ELEMENTOS_POR_PAGINA))
            .map { it.toResponse() }
}