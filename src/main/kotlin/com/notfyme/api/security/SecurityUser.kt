package com.notfyme.api.security

import com.notfyme.api.domain.EmpresaEntity
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

class SecurityUser(empresa: EmpresaEntity) : UserDetails {
    val id: Long
    private val password: String
    private val cnpj: String
    private val permissions: List<SimpleGrantedAuthority>

    init {
        id = empresa.id!!
        cnpj = empresa.cnpj
        password = empresa.password
        permissions = empresa.permissionList.map { SimpleGrantedAuthority("ROLE_${it.nome}") }

    }

    override fun getAuthorities(): List<SimpleGrantedAuthority> {
        return permissions
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return cnpj
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}