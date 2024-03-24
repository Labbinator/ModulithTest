package com.example.ModulithTest.controllerModule.internal

import org.springframework.modulith.events.CompletedEventPublications
import org.springframework.modulith.events.IncompleteEventPublications
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class ResubmitService(val incompleteEvents: IncompleteEventPublications, val completeEvents: CompletedEventPublications) {

    fun resubmitUnpublishedEvents() {
        incompleteEvents.resubmitIncompletePublicationsOlderThan(Duration.ofSeconds(60))
    }

    fun clearPublishedEvents() {
        completeEvents.deletePublicationsOlderThan(Duration.ofSeconds(10))
    }
}