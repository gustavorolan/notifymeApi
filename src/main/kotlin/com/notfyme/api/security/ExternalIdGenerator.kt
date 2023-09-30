package com.notfyme.api.security

fun interface ExternalIdGenerator {
    fun generate(vararg extraInfo: String): String
}