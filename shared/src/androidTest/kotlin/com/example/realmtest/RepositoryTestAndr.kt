package com.example.realmtest

import kotlin.test.Test
import kotlin.test.assertEquals

class RepositoryTestAndr {

    val repository = Repository()

    @Test
    fun createBook() {
        repository.deleteBooks()
        val book = repository.createBook(name = "The Two Towers", description = "Great Book")
        assertEquals(book.name, repository.getBooks().first().name)
    }
}