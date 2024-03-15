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

//    testReverseListNode()

//    testDeleteNode()

//    testDeleteNodeForIndex()

//    testMergeListNodes()

    testLeverOrder()
}

fun testLeverOrder() {
    var node1 = TreeNode(1)
    var node2 = TreeNode(2)
    var node3 = TreeNode(3, node1, node2)
    var node4 = TreeNode(4)
    var node5 = TreeNode(5, node3, node4)

    var result = ListNodeUtil.levelOder(node5)
    for (i in result.indices) {
        for (j in 0 until result[i].size ) {
            println(result[i][j])
        }
    }
}

fun testMergeListNodes() {
    val head1 = ListNode(1)
    head1.next = ListNode(3)
    head1.next.next = ListNode(5)
    head1.next.next.next = ListNode(7)
    head1.next.next.next.next = ListNode(9)


    val head2 = ListNode(2)
    head2.next = ListNode(4)
    head2.next.next = ListNode(6)
    head2.next.next.next = ListNode(8)
    head2.next.next.next.next = ListNode(10)

    var result = ListNodeUtil.mergeListNodes(head1, head2)
    ListNodeUtil.printList(result)
}

fun testDeleteNodeForIndex() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    ListNodeUtil.deleteNodeForIndex(head, 2)
    ListNodeUtil.printList(head)
}

fun testDeleteNode() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    ListNodeUtil.deleteNode(head.next.next)
    ListNodeUtil.printList(head)
}

fun testReverseListNode() {
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
