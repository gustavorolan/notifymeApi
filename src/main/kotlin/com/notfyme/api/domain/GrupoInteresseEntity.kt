package com.notfyme.api.domain

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity(name = "grupoInteresse")
data class GrupoInteresseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank
    val nome: String,

    @ManyToOne
    @JoinColumn(name = "empresaId")
    val empresaEntity: EmpresaEntity,

    @ManyToOne
    @JoinColumn(name = "aplicativoId")
    val aplicativoEntity: AplicativoEntity
)