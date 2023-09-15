package com.gubee.springWithKotlin.repository

import com.gubee.springWithKotlin.models.Client
import org.springframework.data.repository.CrudRepository

interface ClientRepository : CrudRepository<Client, Long> {
    fun findByLogin(login: String): Client?
}