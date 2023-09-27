package com.notfyme.api.domain

import jakarta.persistence.*

@Entity(name = "eventoPlataforma")
data class EventoPlataformaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,


    val plataforma: String,

    @ManyToOne
    @JoinColumn(name = "eventoId")
    val eventoEntity: EventoEntity,

    val enviado: Boolean,

    val mensagem_id_externo: String
)