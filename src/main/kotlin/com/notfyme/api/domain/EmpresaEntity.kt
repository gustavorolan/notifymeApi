package com.notfyme.api.domain

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Entity(name = "empresa")
data class EmpresaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank
    val nome: String,

    @field:NotBlank
    @Column(unique = true)
    val cnpj: String,

    @field:NotBlank @field:Size(min=6)
    @Column(nullable = false)
    val password: String,

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "userIdPermission")
    val permissionList: List<PermissaoEntity> = listOf(),
)
