package com.example.ModulithTest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.modulith.Modulith
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@Modulith
@EnableAsync
class ModulithTestApplication

fun main(args: Array<String>) {
    runApplication<ModulithTestApplication>(*args)
}
