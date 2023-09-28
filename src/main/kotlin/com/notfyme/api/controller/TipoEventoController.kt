package com.notfyme.api.controller

import com.notfyme.api.controller.dto.request.post.PageRequest
import com.notfyme.api.controller.dto.request.post.TipoEventoRequest
import com.notfyme.api.controller.dto.request.put.TipoEventoAlterarRequest
import com.notfyme.api.controller.dto.response.TipoEventoResponse
import com.notfyme.api.service.TipoEventoService
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/tipoEvento")
class TipoEventoController(
    private val tipoEventoService: TipoEventoService
) {

    @PutMapping("/{tipoEventoId}")
    fun alterar(@PathVariable tipoEventoId: Long, @RequestBody tipoEventoAlterarRequest: TipoEventoAlterarRequest): ResponseEntity<String> {
        tipoEventoService.alterar(tipoEventoId, tipoEventoAlterarRequest)
        return ResponseEntity.ok().build()
    }

    @PostMapping
    fun adicionar(@RequestBody tipoEventoRequest: TipoEventoRequest): ResponseEntity<String> {
        val id = tipoEventoService.adicionar(tipoEventoRequest)
        return ResponseEntity.created(URI.create("/tipoEvento/${id}")).build()
    }

    @DeleteMapping("/{tipoEventoId}")
    fun remover(@PathVariable tipoEventoId: Long): ResponseEntity<String> {
        tipoEventoService.remover(tipoEventoId)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/{tipoEventoId}")
    fun obter(@PathVariable tipoEventoId: Long): ResponseEntity<TipoEventoResponse> {
        val tipoEventoResponse = tipoEventoService.obter(tipoEventoId)
        return ResponseEntity.ok(tipoEventoResponse)
    }


    @GetMapping
    fun obterPage(@RequestBody pageRequest: PageRequest): ResponseEntity<Page<TipoEventoResponse>> {
        val pageResponse = tipoEventoService.obterPage(pageRequest)
        return ResponseEntity.ok(pageResponse)
    }
}
