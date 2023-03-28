package com.kt.kot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotApplication

fun main(args: Array<String>) {
	runApplication<KotApplication>(*args)
}
