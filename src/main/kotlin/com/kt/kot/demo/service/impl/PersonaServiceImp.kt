package com.kt.kot.demo.service.impl

import com.kt.kot.demo.commons.GenericServiceImp
import com.kt.kot.demo.model.Persona
import com.kt.kot.demo.repository.PersonaRepository
import com.kt.kot.demo.service.api.PersonaServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class PersonaServiceImp : GenericServiceImp<Persona, Long>(), PersonaServiceAPI {

    @Autowired
    lateinit var personaRepository: PersonaRepository


    override val dao: CrudRepository<Persona, Long>
        get() {
           return personaRepository
        }
}