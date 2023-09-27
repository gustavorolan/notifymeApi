package com.notfyme.api.repository

import com.notfyme.api.domain.AplicativoEntity
import org.springframework.stereotype.Repository

@Repository
interface AplicativoRepository : CustomRepository<AplicativoEntity, Long> {
}
