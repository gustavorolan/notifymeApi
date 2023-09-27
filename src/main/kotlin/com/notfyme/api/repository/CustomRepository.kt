package com.notfyme.api.repository

import org.springframework.data.jpa.repository.JpaRepository

interface CustomRepository<U,T> : JpaRepository<U, T> {
}