package com.notfyme.api.repository

import com.notfyme.api.domain.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TipoEventoRepository : CustomRepository<TipoEventoEntity, Long> {

    fun findByIdAndEmpresaEntityId(id:Long, empresaId:Long): Optional<TipoEventoEntity>

    fun findByEmpresaEntityId(empresaId:Long, pageable: Pageable): Page<TipoEventoEntity>
}
