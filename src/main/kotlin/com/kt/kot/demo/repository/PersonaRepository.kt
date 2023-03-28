package com.kt.kot.demo.repository

import com.kt.kot.demo.model.Persona
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonaRepository : CrudRepository<Persona, Long> {
}