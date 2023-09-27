package com.notfyme.api.service

import com.notfyme.api.controller.dto.EmpresaRequest


interface EmpresaService {
    fun adicionar(empresaRequest: EmpresaRequest):Long
}
