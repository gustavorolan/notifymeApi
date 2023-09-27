package com.notfyme.api.service.impl

import com.notfyme.api.controller.dto.AplicativoRequest
import com.notfyme.api.exception.EmpresaNaoEncontradaException
import com.notfyme.api.exception.EmpresaOuAplicativoNaoEncontradoException
import com.notfyme.api.mapper.toEntity
import com.notfyme.api.mapper.toResponse
import com.notfyme.api.repository.AplicativoRepository
import com.notfyme.api.repository.EmpresaRepository
import com.notfyme.api.service.AplicativoService
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class AplicativoServiceImpl(
    private val empresaRepository: EmpresaRepository,
    private val aplicativoRepository: AplicativoRepository
) : AplicativoService {

    companion object {

        private const val NUMERO_DE_ELEMENTOS_POR_PAGINA = 10

        private const val COLUNA_SORT = "nome"

        private val SORT = Sort.by(Sort.Direction.ASC, COLUNA_SORT)
    }

    override fun adicionar(aplicativoRequest: AplicativoRequest): Long {
        val empresaEntity = empresaRepository.findById(aplicativoRequest.empresaId).orElseThrow { EmpresaNaoEncontradaException() }

        val aplicativoEntity = aplicativoRequest.toEntity(empresaEntity)

        return aplicativoRepository.save(aplicativoEntity).id!!
    }

    override fun remover(aplicativoId: Long, empresaId: Long) {
        val aplicativoEntity = aplicativoRepository.findByIdAndEmpresaEntityId(aplicativoId, empresaId)
            .orElseThrow { EmpresaNaoEncontradaException() }

        aplicativoRepository.delete(aplicativoEntity)
    }

    override fun obter(aplicativoId: Long, empresaId: Long) =
        aplicativoRepository.findByIdAndEmpresaEntityId(aplicativoId, empresaId)
            .orElseThrow { EmpresaOuAplicativoNaoEncontradoException() }
            .toResponse()

    override fun obterPage(empresaId: Long, page: Int) =
        aplicativoRepository.findByEmpresaEntityId(empresaId, obterPageRequest(page))
            .map { it.toResponse() }

    private fun obterPageRequest(page: Int) = PageRequest.of(page, NUMERO_DE_ELEMENTOS_POR_PAGINA, SORT)
}