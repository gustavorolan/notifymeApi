package com.notfyme.api.repository


import com.notfyme.api.domain.EventoPlataformaEntity
import org.springframework.stereotype.Repository

@Repository
interface EventoPlataformaRepository : CustomRepository<EventoPlataformaEntity, Long> {
}
