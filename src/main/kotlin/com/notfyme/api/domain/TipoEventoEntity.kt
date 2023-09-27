package com.notfyme.api.domain

import jakarta.persistence.*

@Entity(name = "tipoEvento")
data class TipoEventoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val nome: String,

    val ativo: Boolean,

    @ManyToOne
    @JoinColumn(name = "empresaId")
    val empresaEntity: EmpresaEntity,
)
