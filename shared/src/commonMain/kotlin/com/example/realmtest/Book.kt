package com.example.realmtest

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import kotlin.random.Random

class Book: RealmObject {
    @PrimaryKey
    var _id: String = "${Random.nextInt()}"
    var name: String = ""
    var description: String = ""
}