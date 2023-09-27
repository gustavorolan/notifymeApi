package com.notfyme.api.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface CustomRepository<U, T> : JpaRepository<U, T> {

}