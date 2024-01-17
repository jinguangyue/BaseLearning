package com.example.myalgorithm

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.myalgorithm.ui.theme.MyAlgorithmTheme


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

        startActivity(Intent(this, TestTouchEventActivity::class.java))

        var head = initializeLinkedList()


        var util: Util = Util()
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

        var node1 = TreeNode(1)
        var node2 = TreeNode(2)
        var node3 = TreeNode(3, node1, node2)
        var node4 = TreeNode(4)
        var node5 = TreeNode(5, node3, node4)

        Log.e("jinguangyue", "maxDepth===" +  util.maxDepth(node5))


        var produceComsumeUtil = ProduceComsumeUtil()
//        produceComsumeUtil.blockingQueueMethod()

        produceComsumeUtil.testIntegerInt();


        ThreadsUtil.countDownLatchExample()


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
