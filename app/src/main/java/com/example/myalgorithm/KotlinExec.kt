package com.example.myalgorithm

class KotlinExec {

}

val util = Util()
val utilKotlin = UtilKotlin()

fun main() {

//    testRemoveDuplicates()

//    testQuickSort()

    testBubbleSort()
}

fun testBubbleSort() {
    val arr = intArrayOf(6, 2, 5, 4, 3, 2, 1, 0)
    utilKotlin.bubbleSort(arr)
}

fun testRemoveDuplicates() {
    /**
     * 删除数组重复项
     */
    val nums = intArrayOf(1, 2, 2, 3, 5, 6)
    util.removeDuplicates(nums)
}

fun testQuickSort() {
    /**
     * 快速排序
     */
    val arr = intArrayOf(6, 5, 4, 3, 2, 1, 0)
    util.quickSort(arr, 0, arr.size - 1)
}
