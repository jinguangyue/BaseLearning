package com.example.myalgorithm.sort

import com.example.myalgorithm.kotlin.hardUtil
import com.example.myalgorithm.kotlin.utilSortKotlin

class SortUtil {
}

fun main() {
    val arr = intArrayOf(64, 34, 25, 12, 22, 11, 90)
    UtilSortKotlin().quickSort(arr, 0, arr.size - 1)
}


fun testIntertSort() {
    val arr = intArrayOf(6, 2, 5, 4, 3, 2, 1, 0)
    utilSortKotlin.insertSort(arr)
}


fun testSelectionSort() {
    val arr = intArrayOf(6, 2, 5, 4, 3, 2, 1, 0)
    utilSortKotlin.selectionSort(arr)
}

fun testBubbleSort() {
    val arr = intArrayOf(6, 2, 5, 4, 3, 2, 1, 0)
    utilSortKotlin.bubbleSort(arr)
}



fun testQuickSort() {
    /**
     * 快速排序
     */
    val arr = intArrayOf(6, 5, 4, 3, 2, 1, 0)
    utilSortKotlin.quickSort(arr, 0, arr.size - 1)
}