package com.notfyme.api.domain

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity(name = "tipoEvento")
data class TipoEventoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank
    val nome: String,

    val ativo: Boolean,

    @ManyToOne
    @JoinColumn(name = "empresaId")
    val empresaEntity: EmpresaEntity,
)
