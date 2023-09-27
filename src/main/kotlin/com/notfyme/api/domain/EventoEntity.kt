package com.notfyme.api.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "evento")
data class EventoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val dataAbertura: LocalDateTime,

    val dataFechamento: LocalDateTime? = null,

    val titulo: String,

    @Lob
    val stackTrace: String,

    val mensagem: String,

    @ManyToOne
    @JoinColumn(name = "aplicativoId")
    val aplicativoEntity: AplicativoEntity,

    @ManyToOne
    @JoinColumn(name = "tipoEventoId")
    val tipoEventoEntity: TipoEventoEntity

)