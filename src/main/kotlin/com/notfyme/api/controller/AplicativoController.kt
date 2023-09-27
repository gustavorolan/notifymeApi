package com.notfyme.api.controller

import com.notfyme.api.controller.dto.AplicativoRequest
import com.notfyme.api.controller.dto.AplicativoResponse
import com.notfyme.api.controller.dto.PageRequest
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

    @PostMapping
    fun adicionar(@RequestBody aplicativoRequest: AplicativoRequest): ResponseEntity<String> {
        val id = aplicativoService.adicionar(aplicativoRequest)
        return ResponseEntity.created(URI.create("/aplicativo/${id}")).build()
    }

    @DeleteMapping("/{aplicativoId}/empresa/{empresaId}")
    fun remover(@PathVariable aplicativoId: Long, @PathVariable empresaId: Long): ResponseEntity<String> {
        aplicativoService.remover(aplicativoId, empresaId)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/{aplicativoId}/empresa/{empresaId}")
    fun obter(@PathVariable aplicativoId: Long, @PathVariable empresaId: Long): ResponseEntity<AplicativoResponse> {
        val aplicativoResponse = aplicativoService.obter(aplicativoId, empresaId)
        return ResponseEntity.ok(aplicativoResponse)
    }


    @GetMapping("/empresa/{empresaId}")
    fun obterPage(@PathVariable empresaId: Long, @RequestBody pageRequest: PageRequest): ResponseEntity<Page<AplicativoResponse>> {
        val pageResponse = aplicativoService.obterPage(empresaId, pageRequest)
        return ResponseEntity.ok(pageResponse)
    }
}
