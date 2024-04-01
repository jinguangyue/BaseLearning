package com.example.myalgorithm

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

class RxJava3 {
    fun main() {
//        Observable.interval(0, 1, TimeUnit.SECONDS)
//            .subscribe(object : Observer<Long>{
//                override fun onSubscribe(d: Disposable) {
//                    TODO("Not yet implemented")
//                }
//
//                override fun onError(e: Throwable) {
//                    TODO("Not yet implemented")
//                }
//
//                override fun onComplete() {
//                    TODO("Not yet implemented")
//                }
//
//                override fun onNext(l: Long) {
//                    TODO("Not yet implemented")
//                }
//
//            })


    }
}


fun main() {
//    val integerObservable = Observable.just(1, 2, 3, 4, 5)
//    val stringObservable = Observable.just("A", "B", "C", "D", "E")
//
//    Observable.zip(
//        integerObservable,
//        stringObservable
//    ) { integer: Int, string: String -> integer.toString() + string } // 将整数和字符串组合成一个新的字符串
//
//        .subscribe(
//            { result: String ->
//                println(
//                    "Result: $result"
//                )
//            },
//            { throwable: Throwable ->
//                System.err.println(
//                    "Error occurred: $throwable"
//                )
//            }
//        ) { println("Completed") }


//    runBlocking {
//        // 使用 async 启动一个异步任务，并返回一个 Deferred<T> 对象
//        val deferredResult: Deferred<String> = async {
//            // 模拟一个耗时操作
//            delay(1000)
//            // 返回结果
//            "Hello"
//        }
//
//        val deferredResultYue: Deferred<String> = async {
//            // 模拟一个耗时操作
//            delay(1000)
//            // 返回结果
//            "yue"
//        }
//
//
//        // 使用 await 方法等待异步任务完成并获取结果
//        val result = deferredResult.await()
//        val resultYue = deferredResultYue.await()
//
//        // 打印结果
//        println("Result: $result - $resultYue")
//    }


    GlobalScope.launch {
        val result1 = async { test1() }
        val result2 = async { test2() }

        val await1 = result1.await()
        val await2 = result2.await()

        println("Result: $await1 - $await2")
    }


    Thread.sleep(3000)
    println("go on")
}

suspend fun test1(): String {
    delay(1000)
    return "hello"
}

suspend fun test2(): String {
    delay(1000)
    return "guangyue"
}