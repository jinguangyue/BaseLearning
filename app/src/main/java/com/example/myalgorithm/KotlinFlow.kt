package com.example.myalgorithm

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

// 生产者协程，产生数据并发送到 Flow 中
fun produceNumbers(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(1000) // 模拟耗时操作
        emit(i)    // 发送数据到 Flow 中
    }
}

fun main() = runBlocking<Unit> {
    // 启动一个消费者协程来处理数据
    val job = launch {
        // 通过 Flow 来消费数据
        produceNumbers().collect { value ->
            println(value) // 在控制台打印数据
        }
    }

    println("Waiting for job to finish")
    job.join() // 等待消费者协程执行完成
    println("Done")
}
