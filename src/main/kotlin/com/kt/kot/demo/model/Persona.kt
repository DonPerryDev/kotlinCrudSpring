package com.kt.kot.demo.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Persona(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column
    val nombre: String,
    @Column
    val apellido: String,
    @Column
    val direccion: String,
    @Column
    val telefono: String
){

}
