package com.notfyme.api.controller

import com.notfyme.api.controller.dto.request.post.GrupoInteresseTipoEventoRequest
import com.notfyme.api.controller.dto.request.post.PageRequest
import com.notfyme.api.controller.dto.response.GrupoInteresseTipoEventoResponse
import com.notfyme.api.service.GrupoInteresseTipoEventoService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/grupoInteresseTipoEvento")
class GrupoInteresseTipoEventoTipoEventoController(
    private val grupoInteresseTipoEventoService: GrupoInteresseTipoEventoService
) {

    @PostMapping
    fun adicionar(@Valid @RequestBody grupoInteresseTipoEventoRequest: GrupoInteresseTipoEventoRequest): ResponseEntity<String> {
        val id = grupoInteresseTipoEventoService.adicionar(grupoInteresseTipoEventoRequest)
        return ResponseEntity.created(URI.create("/grupoInteresseTipoEvento/${id}")).build()
    }

    @DeleteMapping("/{grupoInteresseTipoEventoId}")
    fun remover(@PathVariable grupoInteresseTipoEventoId: Long): ResponseEntity<String> {
        grupoInteresseTipoEventoService.remover(grupoInteresseTipoEventoId)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/{grupoInteresseTipoEventoId}")
    fun obter(@PathVariable grupoInteresseTipoEventoId: Long): ResponseEntity<GrupoInteresseTipoEventoResponse> {
        val grupoInteresseTipoEventoResponse = grupoInteresseTipoEventoService.obter(grupoInteresseTipoEventoId)
        return ResponseEntity.ok(grupoInteresseTipoEventoResponse)
    }


    @GetMapping
    fun obterPage(@RequestBody pageRequest: PageRequest): ResponseEntity<Page<GrupoInteresseTipoEventoResponse>> {
        val pageResponse = grupoInteresseTipoEventoService.obterPage(pageRequest)
        return ResponseEntity.ok(pageResponse)
    }
}
