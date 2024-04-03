package com.example.myalgorithm

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.myalgorithm.arraylist.MyArrayList
import com.example.myalgorithm.livedata.LiveDataActivity
import com.example.myalgorithm.view.ViewTreeTraversal
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


@Composable
fun MyButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Click me")
    }
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                MyButton(onClick = {
                    startActivity(Intent(this@MainActivity, LiveDataActivity::class.java))
                })
            }
//            MyAlgorithmTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Box(
//                        modifier = Modifier.fillMaxSize(),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Text(
//                            text = "Hello, Compose!",
//                            color = Color.Black,
//                            textAlign = TextAlign.Center
//                        )
//                    }
//                }
//            }
        }

//        startActivity(Intent(this, TestTouchEventActivity::class.java))

//        var head = initializeLinkedList()

//        TextView(this).setOnClickListener()


        var util: Util = Util()


//        val arr = intArrayOf(64, 34, 25, 12, 22, 11, 90)
//        util.quickSort(arr, 0, arr.size - 1)
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

//        var node1 = TreeNode(4)
//        var node2 = TreeNode(5)
//        var node3 = TreeNode(2, node1, node2)
//
//        var node6 = TreeNode(6)
//        var node7 = TreeNode(7)
//        var node4 = TreeNode(3, node6, node7)
//        var node5 = TreeNode(1, node3, node4)
////
//        Log.e("jinguangyue", "levelOrder===" +  util.levelOrder(node5))


//        var produceComsumeUtil = ProduceComsumeUtil()
//        produceComsumeUtil.blockingQueueMethod()

//        produceComsumeUtil.testIntegerInt();


//        ThreadsUtil.countDownLatchExample()


//        testRotateList()


//        testRetrofit()
//
//        var framelayout = FrameLayout(this)
//        var framelayout1 = FrameLayout(this)
//        var framelayout2 = FrameLayout(this)
//        framelayout.addView(framelayout1)
//        framelayout.addView(framelayout2)
//
//        framelayout1.addView(TextView(this).apply {
//            id = R.id.set_data_button
//            text = "111" })
//        framelayout1.addView(TextView(this).apply { text = "222" })
//
//
//        framelayout2.addView(TextView(this).apply { text = "333" })
//        framelayout2.addView(TextView(this).apply { text = "444" })
//
//
//        ViewTreeTraversal().traverseViewTreeForWhile(framelayout)



        var myArrayList  = MyArrayList<String>()
        myArrayList.add("1")
        myArrayList.add("2")
        myArrayList.add("3")

        myArrayList.remove(2)

        for (i in 0 until myArrayList.size) {
            Log.e("jinguangyue", myArrayList[i])
        }
    }

    private fun testRetrofit() {
    }

    private fun testRotateList() {

        GlobalScope.launch ( context = Dispatchers.IO){

        }

        suspend {

        }

        runBlocking {
            // 使用 async 启动一个异步任务，并返回一个 Deferred<T> 对象
            val deferredResult: Deferred<String> = async {
                // 模拟一个耗时操作
                delay(1000)
                // 返回结果
                "Hello"
            }

            val deferredResultYue: Deferred<String> = async {
                // 模拟一个耗时操作
                delay(1000)
                // 返回结果
                "yue"
            }


            // 使用 await 方法等待异步任务完成并获取结果
            val result = deferredResult.await()
            val resultYue = deferredResultYue.await()

            // 打印结果
            println("Result: $result - $resultYue")
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
