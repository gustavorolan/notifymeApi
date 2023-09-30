package com.notfyme.api.security

fun interface ApiKeyService {
    fun generateHash(vararg extraInfo: String): String
}