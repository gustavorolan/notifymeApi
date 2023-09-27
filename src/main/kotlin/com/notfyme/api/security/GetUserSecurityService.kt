package com.notfyme.api.security

import com.notfyme.api.repository.EmpresaRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class GetUserSecurityService(private val empresaRepository: EmpresaRepository) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(cnpj: String): UserDetails {
        val empresaEntity = empresaRepository.findByCnpj(cnpj)
        return SecurityUser(empresaEntity)
    }
}
