package com.notfyme.api.domain

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity(name = "botGrupoInteresse")
data class BotGrupoInteresseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank
    val nome: String,

    @ManyToOne
    @JoinColumn(name = "grupoInteresseId")
    val grupoInteresseEntity: GrupoInteresseEntity,

    @ManyToOne
    @JoinColumn(name = "botPlataformaId")
    val botPlataformaEntity: BotPlataformaEntity,

    @field:NotBlank
    val grupoExternalId: String

)