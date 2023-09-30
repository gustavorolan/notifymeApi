package com.notfyme.api.security

import org.springframework.stereotype.Service

@Service
class ExternalIdGeneratorImpl(private val apiKeyService: ApiKeyService) : ExternalIdGenerator {
    override fun generate(vararg extraInfo: String): String {
        return apiKeyService.generateHash(extraInfo.contentDeepToString()).substring(0, 8)
    }
}