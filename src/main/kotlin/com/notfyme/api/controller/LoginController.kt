package com.notfyme.api.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController {
    @GetMapping("/login")
    fun login(): ResponseEntity<String> =
        ResponseEntity.ok().build()
}