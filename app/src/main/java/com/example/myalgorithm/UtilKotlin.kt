package com.example.myalgorithm

class UtilKotlin {


    /**
     * 选择排序算法
     */
    internal fun selectionSort(arr: IntArray) {
        var minIndex: Int
        var maxIndex: Int
        for (i in 0 until arr.size / 2) {
            minIndex = i
            maxIndex = i
            for (j in i + 1 until arr.size - i) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j
                }

                if (arr[maxIndex] < arr[j]) {
                    maxIndex = j
                }
            }

            swap(arr, i, minIndex)

            if (maxIndex == minIndex) {
                break
            }

            if (maxIndex == i) {
                maxIndex = minIndex
            }

            val lastIndex = arr.size - i - 1
            swap(arr, lastIndex, maxIndex)

        }

        printArray(arr)
    }


    /**
     * 冒泡排序算法
     */
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
        println("jinguangyue-swap---start:" + "arr[i]:" + arr[i] + "-----" + "arr[j]):" + arr[j])

        if (arr[i] != arr[j]) {
            arr[i] = arr[i] xor arr[j]
            arr[j] = arr[i] xor arr[j]
            arr[i] = arr[i] xor arr[j]
        }

        println("jinguangyue-swap---end:" + "arr[i]:" + arr[i] + "-----" + "arr[j]):" + arr[j])

        println()
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