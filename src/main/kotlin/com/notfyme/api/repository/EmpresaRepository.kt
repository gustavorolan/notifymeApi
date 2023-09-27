package com.notfyme.api.repository

import com.notfyme.api.domain.EmpresaEntity
import org.springframework.stereotype.Repository

@Repository
interface EmpresaRepository : CustomRepository<EmpresaEntity, Long> {
    fun findByCnpj(cnpj:String):EmpresaEntity
}
