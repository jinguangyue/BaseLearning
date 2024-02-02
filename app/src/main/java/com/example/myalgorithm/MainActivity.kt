package com.example.myalgorithm

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.myalgorithm.ui.theme.MyAlgorithmTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



fun MainActivity.setContentView(id: Int) {

}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAlgorithmTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }

//        startActivity(Intent(this, TestTouchEventActivity::class.java))

//        var head = initializeLinkedList()


        var util: Util = Util()


        val arr = intArrayOf(64, 34, 25, 12, 22, 11, 90)
        util.quickSort(arr, 0, arr.size - 1)
//        Log.e("jinguangyue", "result===" + util.reverseList(head).`val`);
//        val arr2 = intArrayOf(1, 2, 3)
//        Log.e("jinguangyue", "removeDuplicates===" + util.removeDuplicates(arr2))
//
//
//        val maxprice = intArrayOf(1, 2, 3, 4, 5)
//
//        Log.e("jinguangyue", "maxProfit===" + util.maxProfit(maxprice))
//
//        Log.e("jinguangyue", "reverse---int===" + util.reverse(1534236469).toString());


//        util.myAtoi(" ")

//        Log.e("jinguangyue", "result===" + util.kmpSearch("ABABABABCABABABABCABABABABC", "ABABCABAB"))

//        var node1 = TreeNode(1)
//        var node2 = TreeNode(2)
//        var node3 = TreeNode(3, node1, node2)
//        var node4 = TreeNode(4)
//        var node5 = TreeNode(5, node3, node4)
//
//        Log.e("jinguangyue", "maxDepth===" +  util.maxDepth(node5))


//        var produceComsumeUtil = ProduceComsumeUtil()
//        produceComsumeUtil.blockingQueueMethod()

//        produceComsumeUtil.testIntegerInt();


//        ThreadsUtil.countDownLatchExample()


//        testRotateList()


    }

    private fun testRotateList() {

        GlobalScope.launch ( context = Dispatchers.IO){

        }

        suspend {

        }


        // 构建链表 "1 -> 2 -> 3 -> 4 -> 5"
        // 构建链表 "1 -> 2 -> 3 -> 4 -> 5"
        val head = ListNode(1)
        head.next = ListNode(2)
        head.next.next = ListNode(3)
        head.next.next.next = ListNode(4)
        head.next.next.next.next = ListNode(5)


        println("Original List:")
        printList(head)

        // 旋转链表

        // 旋转链表
        val k = 2
        val rotatedHead = rotateList(head, k)

        println("Rotated List:")
        printList(rotatedHead)
    }

    fun rotateList(head: ListNode?, k: Int): ListNode? {
        var k = k
        if (head == null || k <= 0) {
            return head
        }

        // 计算链表的长度
        var length = 1
        var current: ListNode = head
        while (current.next != null) {
            current = current.next
            length++
        }

        // 计算实际需要旋转的步数
        k = k % length
        if (k == 0) {
            return head // 不需要旋转
        }

        // 找到旋转位置的前一个节点
        var newHead: ListNode = head
        for (i in 0 until length - k - 1) {
            newHead = newHead.next
        }

        // 旋转链表
        val rotatedHead = newHead.next
        newHead.next = null // 断开原链表

        // 找到原链表的最后一个节点
        current = rotatedHead
        while (current.next != null) {
            current = current.next
        }

        // 将原链表的最后一个节点的 next 指向原链表的头节点
        current.next = head
        return rotatedHead
    }

    fun printList(head: ListNode?) {
        var head = head
        while (head != null) {
            Log.e("jinguangyue", head.`val`.toString() + " -> ")
            head = head.next
        }
        println("null")
    }


    fun initializeLinkedList(): ListNode? {
        val head = ListNode(1)
        var current: ListNode = head

        // 添加其他节点
        current.next = ListNode(2)
        current = current.next
        current.next = ListNode(3)
        current = current.next
        current.next = ListNode(4)
        current = current.next
        current.next = ListNode(5)
        current = current.next
        current.next = ListNode(6)
        return head
    }
}
