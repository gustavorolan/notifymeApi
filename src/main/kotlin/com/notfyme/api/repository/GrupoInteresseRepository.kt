package com.notfyme.api.repository

import com.notfyme.api.domain.GrupoInteresseEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface GrupoInteresseRepository : CustomRepository<GrupoInteresseEntity, Long> {

    fun findByIdAndEmpresaEntityId(id: Long, empresaId: Long): Optional<GrupoInteresseEntity>

    fun findByEmpresaEntityId(empresaId: Long, pageable: Pageable): Page<GrupoInteresseEntity>

    fun findByEmpresaEntityIdAndAplicativoEntityId(empresaId: Long, aplicativoId: Long, pageable: Pageable): Page<GrupoInteresseEntity>
}
