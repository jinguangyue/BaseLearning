package com.example.myalgorithm.kotlin

import kotlin.reflect.KProperty

class KotlinByLazy {

    var token by Saver()
    var token2 by Saver()

    val lazyTest by lazy {
        Saver()
    }

    fun test() {
    }
}

class Saver {
    operator fun getValue(kotlinByLazy: KotlinByLazy, property: KProperty<*>): Any {
        TODO("Not yet implemented")
    }

    operator fun setValue(kotlinByLazy: KotlinByLazy, property: KProperty<*>, any: Any) {
        TODO("Not yet implemented")
    }

}
