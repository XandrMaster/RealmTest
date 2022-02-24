package com.example.realmtest

import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.query

class Repository(name: String = "compendium") {

//    val config = RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().name(name).schema(
//        setOf(
//            Book::class
//        )
//    ).build()
    val config = RealmConfiguration.with(setOf(Book::class))
    val realm: Realm = Realm.open(config)

    fun deleteBooks() {
        realm.writeBlocking {
            query<Book>().find().delete()
        }
    }

    fun createBook(name: String, description: String) : Book {
        val book = Book().apply {
            this.name = name
            this.description = description
        }

        realm.writeBlocking {
            copyToRealm(book)
        }

        return book
    }

    fun getBooks(): List<Book> {
        return realm.query<Book>().find().toList()
    }
}