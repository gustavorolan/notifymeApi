package com.notfyme.api.domain

import jakarta.persistence.*

@Entity(name = "botGrupoInteresse")
data class BotGrupoInteresseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val nome: String,

    @ManyToOne
    @JoinColumn(name = "grupoInteresseId")
    val grupoInteresseEntity: GrupoInteresseEntity,

    @ManyToOne
    @JoinColumn(name = "botPlataformaId")
    val botPlataformaEntity: BotPlataformaEntity,

    val grupoExternalId: String

)