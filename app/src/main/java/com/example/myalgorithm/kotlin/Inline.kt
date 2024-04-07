package com.example.myalgorithm.kotlin

class Inline {

    fun main() {
        messageTime { println("inline") }
    }

    private inline fun messageTime(action: () -> Unit) {
        action()
    }
}