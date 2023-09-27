package com.notfyme.api.repository

import com.notfyme.api.domain.GrupoInteresseEntity
import org.springframework.stereotype.Repository

@Repository
interface GrupoInteresseRepository : CustomRepository<GrupoInteresseEntity, Long> {
}
