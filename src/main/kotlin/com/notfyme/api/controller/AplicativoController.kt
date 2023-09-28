package com.notfyme.api.controller

import com.notfyme.api.controller.dto.request.put.AplicativoAlterarRequest
import com.notfyme.api.controller.dto.request.post.AplicativoRequest
import com.notfyme.api.controller.dto.response.AplicativoResponse
import com.notfyme.api.controller.dto.request.post.PageRequest
import com.notfyme.api.service.AplicativoService
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/aplicativo")
class AplicativoController(
    private val aplicativoService: AplicativoService
) {

    @PutMapping("/{aplicativoId}")
    fun alterar(@PathVariable aplicativoId:Long, @RequestBody aplicativoAlterarRequest: AplicativoAlterarRequest): ResponseEntity<String> {
        aplicativoService.alterar(aplicativoId, aplicativoAlterarRequest)
        return ResponseEntity.ok().build()
    }

    @PostMapping
    fun adicionar(@RequestBody aplicativoRequest: AplicativoRequest): ResponseEntity<String> {
        val id = aplicativoService.adicionar(aplicativoRequest)
        return ResponseEntity.created(URI.create("/aplicativo/${id}")).build()
    }

    @DeleteMapping("/{aplicativoId}")
    fun remover(@PathVariable aplicativoId: Long): ResponseEntity<String> {
        aplicativoService.remover(aplicativoId)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/{aplicativoId}")
    fun obter(@PathVariable aplicativoId: Long): ResponseEntity<AplicativoResponse> {
        val aplicativoResponse = aplicativoService.obter(aplicativoId)
        return ResponseEntity.ok(aplicativoResponse)
    }


    @GetMapping
    fun obterPage(@RequestBody pageRequest: PageRequest): ResponseEntity<Page<AplicativoResponse>> {
        val pageResponse = aplicativoService.obterPage(pageRequest)
        return ResponseEntity.ok(pageResponse)
    }
}
