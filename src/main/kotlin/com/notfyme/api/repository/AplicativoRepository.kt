package com.notfyme.api.repository

import com.notfyme.api.domain.AplicativoEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AplicativoRepository : CustomRepository<AplicativoEntity, Long> {

    fun findByIdAndEmpresaEntityId(id:Long, empresaId:Long):Optional<AplicativoEntity>

    fun findByEmpresaEntityId(empresaId:Long, pageable: Pageable): Page<AplicativoEntity>
}
