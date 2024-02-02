package com.example.myalgorithm

class Inline {

    fun main() {
        messageTime { println("inline") }
    }

    private inline fun messageTime(action: () -> Unit) {
        action()
    }
}