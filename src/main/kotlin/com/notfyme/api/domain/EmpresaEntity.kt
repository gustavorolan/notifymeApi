package com.notfyme.api.domain

import jakarta.persistence.*

@Entity(name = "empresa")
data class EmpresaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val nome: String,

    @Column(unique = true)
    val cnpj: String,

    @Column(nullable = false)
    val password: String,

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "userIdPermission")
    val permissionList: List<PermissaoEntity> = listOf(),
)
