package com.notfyme.api.controller

import com.notfyme.api.controller.dto.request.GrupoInteresseRequest
import com.notfyme.api.controller.dto.request.PageRequest
import com.notfyme.api.controller.dto.response.GrupoInteresseResponse
import com.notfyme.api.service.GrupoInteresseService
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/grupoInteresse")
class GrupoInteresseController(
    private val grupoInteresseService: GrupoInteresseService
) {

    @PostMapping
    fun adicionar(@RequestBody grupoInteresseRequest: GrupoInteresseRequest): ResponseEntity<String> {
        val id = grupoInteresseService.adicionar(grupoInteresseRequest)
        return ResponseEntity.created(URI.create("/aplicativo/${id}")).build()
    }

    @DeleteMapping("/{grupoInteresseId}")
    fun remover(@PathVariable grupoInteresseId: Long): ResponseEntity<String> {
        grupoInteresseService.remover(grupoInteresseId)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/{grupoInteresseId}")
    fun obter(@PathVariable grupoInteresseId: Long): ResponseEntity<GrupoInteresseResponse> {
        val grupoInteresseResponse = grupoInteresseService.obter(grupoInteresseId)
        return ResponseEntity.ok(grupoInteresseResponse)
    }


    @GetMapping
    fun obterPage(@RequestBody pageRequest: PageRequest): ResponseEntity<Page<GrupoInteresseResponse>> {
        val pageResponse = grupoInteresseService.obterPage(pageRequest)
        return ResponseEntity.ok(pageResponse)
    }

    @GetMapping("/aplicativo/{aplicativoId}")
    fun obterPageAplicativo(@PathVariable aplicativoId: Long, @RequestBody pageRequest: PageRequest): ResponseEntity<Page<GrupoInteresseResponse>> {
        val pageResponse = grupoInteresseService.obterPage(aplicativoId, pageRequest)
        return ResponseEntity.ok(pageResponse)
    }
}
