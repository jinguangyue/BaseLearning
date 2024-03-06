package com.example.myalgorithm

class UtilKotlin {
    public fun bubbleSort(arr: IntArray) {

        var isSwap = false

        for (i in 0 until arr.size) {
            for (j in 0 until arr.size - i - 1) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1)
                    isSwap = true
                }
            }

            if (!isSwap) break
        }

        printArray(arr)
    }

    public fun swap(arr: IntArray, i: Int, j: Int) {
        arr[i] = arr[i] xor arr[j]
        arr[j] = arr[j] xor(arr[i])
        arr[i] = arr[i] xor arr[j]
    }

    fun printArray(arr: IntArray) {
        for (num in arr) {
            print("$num-")
        }
    }
}