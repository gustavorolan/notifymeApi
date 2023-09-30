package com.notfyme.api.domain

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity(name = "eventoPlataforma")
data class EventoPlataformaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank
    val plataforma: String,

    @ManyToOne
    @JoinColumn(name = "eventoId")
    val eventoEntity: EventoEntity,

    @field:NotBlank
    val enviado: Boolean,

    @field:NotBlank
    val mensagemIdExterno: String
)