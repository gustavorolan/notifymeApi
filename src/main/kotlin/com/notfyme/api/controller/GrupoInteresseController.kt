package com.notfyme.api.controller

import com.notfyme.api.controller.dto.request.put.GrupoInteresseAlterarRequest
import com.notfyme.api.controller.dto.request.post.GrupoInteresseRequest
import com.notfyme.api.controller.dto.request.post.PageRequest
import com.notfyme.api.controller.dto.response.GrupoInteresseResponse
import com.notfyme.api.service.GrupoInteresseService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/grupoInteresse")
class GrupoInteresseController(
    private val grupoInteresseService: GrupoInteresseService
) {

    @PutMapping("/{grupoInteresseId}")
    fun adicionar(@PathVariable grupoInteresseId:Long,@Valid @RequestBody grupoInteresseAlterarRequest: GrupoInteresseAlterarRequest): ResponseEntity<String> {
        grupoInteresseService.alterar(grupoInteresseId, grupoInteresseAlterarRequest)
        return ResponseEntity.ok().build()
    }

    @PostMapping
    fun adicionar(@Valid @RequestBody grupoInteresseRequest: GrupoInteresseRequest): ResponseEntity<String> {
        val id = grupoInteresseService.adicionar(grupoInteresseRequest)
        return ResponseEntity.created(URI.create("/grupoInteresseId/${id}")).build()
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
