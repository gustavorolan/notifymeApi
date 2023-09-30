package com.notfyme.api.repository

import com.notfyme.api.domain.BotPlataformaEntity
import org.springframework.stereotype.Repository

@Repository
interface BotPlataformaRepository : CustomRepository<BotPlataformaEntity, Long>
