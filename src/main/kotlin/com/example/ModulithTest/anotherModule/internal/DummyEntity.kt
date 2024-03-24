package com.example.ModulithTest.anotherModule.internal

import jakarta.persistence.*

@Entity
class DummyEntity (

    @Column(nullable = false)
    val name: String,

    @Column(nullable = true)
    @Lob
    val blob: ByteArray,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int?=null
)
