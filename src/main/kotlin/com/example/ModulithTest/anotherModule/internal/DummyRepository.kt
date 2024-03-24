package com.example.ModulithTest.anotherModule.internal

import org.springframework.data.jpa.repository.JpaRepository

interface DummyRepository : JpaRepository<DummyEntity, Int>