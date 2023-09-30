package com.notfyme.api.domain

import br.com.brunoszczuk.notifymeapi.valueobject.PlataformaEnum
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank

@Entity(name = "botPlataforma")
data class BotPlataformaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank
    val token: String,

    @field:NotBlank
    @Enumerated(value = EnumType.STRING)
    val plataforma: PlataformaEnum
)