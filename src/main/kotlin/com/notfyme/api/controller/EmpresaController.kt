package com.notfyme.api.controller

import com.notfyme.api.controller.dto.request.post.EmpresaRequest
import com.notfyme.api.service.EmpresaService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RequestMapping("/empresa")
@RestController
class EmpresaController (
    private val empresaService: EmpresaService
) {
    @PostMapping("/adicionar")
    fun adicionar(@Valid @RequestBody empresaRequest: EmpresaRequest): ResponseEntity<String> {
        val empresaId = empresaService.adicionar(empresaRequest)
        return ResponseEntity.created(URI.create("empresa/$empresaId")).build()
    }
}