package com.kt.kot.demo.controller

import com.kt.kot.demo.model.Persona
import com.kt.kot.demo.service.api.PersonaServiceAPI
import com.kt.kot.demo.service.impl.PersonaServiceImp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class PersonaController {

    @Autowired
    lateinit var personaServiceAPI: PersonaServiceAPI

    @GetMapping
    fun getAll(): MutableList<Persona> {
        return personaServiceAPI.all ?: ArrayList<Persona>()
    }

    @PostMapping
    fun save(@RequestBody persona: Persona): ResponseEntity<Persona> {
        val obj = personaServiceAPI.save(persona)
        return ResponseEntity<Persona>(obj, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Persona> {
        return if (personaServiceAPI.get(id) != null) {
            personaServiceAPI.delete(id)
            ResponseEntity(HttpStatus.OK)
        } else {
            ResponseEntity<Persona>(HttpStatus.NO_CONTENT)
        }
    }

}