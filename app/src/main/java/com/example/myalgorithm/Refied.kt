package com.example.myalgorithm


fun main() {
    println(Refied.create<Refied.API>())
}

object Refied {
    inline fun <reified T> create() : Class<T> {
        return T::class.java
    }

    class API {

    }
}