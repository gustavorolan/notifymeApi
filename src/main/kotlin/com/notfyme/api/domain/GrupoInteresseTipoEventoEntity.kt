package com.notfyme.api.domain

import jakarta.persistence.*

@Entity(name = "grupoInteresseTipoEvento")
data class GrupoInteresseTipoEventoEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "grupoInteresseId")
    val grupoInteresseEntity: GrupoInteresseEntity,

    @ManyToOne
    @JoinColumn(name = "grupoInteresseId")
    val tipoEventoEntity: TipoEventoEntity,
)
