package com.notfyme.api.security

import com.notfyme.api.domain.EmpresaEntity
import com.notfyme.api.repository.EmpresaRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class EmpresaAutenticadaService(
    private val empresaRepository: EmpresaRepository
) {
    val empresaEntity: EmpresaEntity
        get() {
            val authentication = SecurityContextHolder.getContext().authentication
            val securityUser: SecurityUser = authentication.principal as SecurityUser
            return empresaRepository.findById(securityUser.id).get()
        }

    fun  getId():Long = empresaEntity.id!!

}
