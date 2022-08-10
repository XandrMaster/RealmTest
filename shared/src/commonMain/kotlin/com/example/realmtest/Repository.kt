package com.example.realmtest

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class Repository(name: String = "compendium") {

	//    val config = RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().name(name).schema(
//        setOf(
//            Book::class
//        )
//    ).build()
	val config = RealmConfiguration
		.Builder(setOf(Book::class))
		.schemaVersion(2)
		.build()
	val realm: Realm = Realm.open(config)

	fun deleteBooks() {
		realm.writeBlocking {
			query(Book::class).first().find()?.apply {
				delete(this)
			}
		}
	}

	fun createBook(name: String, description: String): Book {
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
		return realm.query(Book::class).find().toList()
	}
}