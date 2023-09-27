package com.notfyme.api.repository

import com.notfyme.api.domain.EventoEntity
import org.springframework.stereotype.Repository

@Repository
interface EventoRepository : CustomRepository<EventoEntity, Long> {
}
