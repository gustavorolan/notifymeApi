package com.notfyme.api.repository

import com.notfyme.api.domain.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface GrupoInteresseTipoEventoRepository : CustomRepository<GrupoInteresseTipoEventoEntity, Long> {

    fun findByIdAndGrupoInteresseEntityEmpresaEntityId(id: Long, empresaId: Long): Optional<GrupoInteresseTipoEventoEntity>

    fun findByGrupoInteresseEntityEmpresaEntityId(empresaId: Long, pageable: Pageable): Page<GrupoInteresseTipoEventoEntity>
}
