package com.notfyme.api.domain

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank


@Entity(name = "aplicativo")
data class AplicativoEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank
    val nome: String,

    @ManyToOne
    @JoinColumn(name = "empresaId")
    val empresaEntity: EmpresaEntity,

    @field:NotBlank
    val apiKey: String,
)