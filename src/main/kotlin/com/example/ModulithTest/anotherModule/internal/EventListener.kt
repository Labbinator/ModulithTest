package com.example.ModulithTest.anotherModule.internal

import com.example.ModulithTest.controllerModule.TestEvent
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component

@Component
class EventListener(var dummyRepository: DummyRepository) {

    @ApplicationModuleListener
    public fun on(event: TestEvent) {
        println(event.blob.toString(Charsets.UTF_8).substring(0, 10))
        println("Received event: ${event.toString().substring(0, 50)}...")

        dummyRepository.save(DummyEntity(event.message, event.blob))
    }
}