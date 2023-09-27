package com.notfyme.api.repository

import com.notfyme.api.domain.*
import org.springframework.stereotype.Repository

@Repository
interface TipoEventoRepository : CustomRepository<TipoEventoEntity, Long> {
}
