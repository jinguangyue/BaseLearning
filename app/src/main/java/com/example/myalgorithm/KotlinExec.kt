package com.example.myalgorithm

class KotlinExec {

}

val util = Util()
val utilKotlin = UtilKotlin()

fun main() {

//    testRemoveDuplicates()

//    testQuickSort()

//    testBubbleSort()


//    testSelectionSort()

//    testIntertSort()

    testListNode()
}

fun testListNode() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)

    var result = ListNodeUtil.reverseList(head)

    ListNodeUtil.printList(result)
}

fun testIntertSort() {
    val arr = intArrayOf(6, 2, 5, 4, 3, 2, 1, 0)
    utilKotlin.insertSort(arr)
}


fun testSelectionSort() {
    val arr = intArrayOf(6, 2, 5, 4, 3, 2, 1, 0)
    utilKotlin.selectionSort(arr)
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
