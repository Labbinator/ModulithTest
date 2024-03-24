package com.example.ModulithTest.controllerModule.internal

import com.example.ModulithTest.controllerModule.TestEvent
import jakarta.transaction.Transactional
import org.springframework.context.ApplicationEventPublisher
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/test")
class TestController(val applicationEventPublisher: ApplicationEventPublisher, val resubmitService: ResubmitService) {

    @GetMapping("/clear")
    fun clear(): String {
        println("Clearing events...")
        resubmitService.clearPublishedEvents()
        return "OK"
    }

    @GetMapping("/repub")
    fun repub(): String {
        println("Repub events...")
        resubmitService.resubmitUnpublishedEvents()
        return "OK"
    }

    @PutMapping(consumes = ["application/json"])
    @Transactional
    fun put(@RequestBody blob: ByteArray): String {
        println(blob.toString(Charsets.UTF_8).substring(0, 10))
        val event = TestEvent("AAA", blob)
        println("Publish event: ${event.toString().substring(0, 50)}...")
        applicationEventPublisher.publishEvent(event)
        return "OK"
    }
}