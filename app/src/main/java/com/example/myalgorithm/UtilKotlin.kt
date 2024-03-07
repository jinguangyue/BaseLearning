package com.example.myalgorithm

class UtilKotlin {

    internal fun selectionSort(arr: IntArray) {
        var minIndex: Int
        for (i in 0 until arr.size - 1) {
            minIndex = i
            for (j in i + 1 until arr.size) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j
                }
            }

            swap(arr, i, minIndex)
        }

        printArray(arr)
    }

    public fun bubbleSort(arr: IntArray) {

        var indexOfLastUnSortElement = arr.size - 1
        var isSwap = true
        var lastSwapIndex = -1

        while (isSwap) {
            isSwap = false
            for (i in 0 until indexOfLastUnSortElement) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1)
                    isSwap = true
                    lastSwapIndex = i
                }
            }

            indexOfLastUnSortElement = lastSwapIndex
        }


//        for (i in 0 until arr.size) {
//            for (j in 0 until arr.size - i - 1) {
//                if (arr[j] > arr[j + 1]) {
//                    swap(arr, j, j + 1)
//                    isSwap = true
//                }
//            }
//
//            if (!isSwap) break
//        }

        printArray(arr)
    }

    public fun swap(arr: IntArray, i: Int, j: Int) {
        println("jinguangyue-swap---start:" + "arr[i]:" + arr[i] + "arr[j]):" + arr[j])

        if (arr[i] != arr[j]) {
            arr[i] = arr[i] xor arr[j]
            arr[j] = arr[i] xor arr[j]
            arr[i] = arr[i] xor arr[j]
        }

        println("jinguangyue-swap---end:" + "arr[i]:" + arr[i] + "arr[j]):" + arr[j])

//        var temp = arr[i]
//        arr[i] = arr[j]
//        arr[j] = temp
    }

    fun printArray(arr: IntArray) {
        for (num in arr) {
            print("$num-")
        }
    }
}