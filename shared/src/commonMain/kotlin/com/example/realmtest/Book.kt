package com.example.realmtest

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import kotlin.random.Random

class Book: RealmObject {
    @PrimaryKey
    var _id: String = "${Random.nextInt()}"
    var name: String = ""
    var description: String = ""
}