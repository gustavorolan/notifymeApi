package com.notfyme.api.domain

import jakarta.persistence.*


@Entity(name = "aplicativo")
data class AplicativoEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val nome: String,

    @ManyToOne
    @JoinColumn(name = "empresaId")
    val empresaEntity: EmpresaEntity,

    val apiKey: String,
)