package com.notfyme.api.service.impl


import com.notfyme.api.controller.dto.request.post.EmpresaRequest
import com.notfyme.api.mapper.toEntity
import com.notfyme.api.repository.EmpresaRepository
import com.notfyme.api.service.EmpresaService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(
    private val empresaRepository: EmpresaRepository,
    private val passwordEncoder: PasswordEncoder,
) : EmpresaService {
    override fun adicionar(empresaRequest: EmpresaRequest): Long {

        val empresaRequestEncoded = empresaRequest.copy(password = passwordEncoder.encode(empresaRequest.password))

        return empresaRepository.save(empresaRequestEncoded.toEntity()).id!!
    }
}