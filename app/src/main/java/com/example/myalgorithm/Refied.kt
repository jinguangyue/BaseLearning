package com.example.myalgorithm


fun main() {
    println(Refied.create<Double>())
}

object Refied {
    inline fun <reified T> create() {
        val name = T::class.simpleName
        println(name)
    }

    class API {

    }
}