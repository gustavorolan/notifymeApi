package com.notfyme.api.security

import org.springframework.stereotype.Service
import java.security.MessageDigest
import java.time.Instant

@Service
class ApiKeyServiceImpl : ApiKeyService {
    override fun generateHash(vararg extraInfo: String): String {
        val sha256 = MessageDigest.getInstance("SHA-256")
        val timestampStr = Instant.now().epochSecond.toString()
        val hash = sha256.digest(timestampStr.toByteArray())
        return hash.fold("") { str, it -> str + "%02x".format(it) }
    }
}