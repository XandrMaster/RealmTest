package com.example.realmtest

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}