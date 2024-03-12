package com.example.myalgorithm

import java.util.Deque
import java.util.LinkedList

class ListNodeUtil {
    companion object {


        /**
         * 删除链表倒数第n个节点
         */
        fun deleteNodeForIndex(node: ListNode, index: Int) : ListNode {
//            var dummy = ListNode(0, node)
//            var cur = node
//            var count = 0
//            while (cur != null) {
//                count++
//                if (cur.next == null) break
//                cur = cur.next
//            }
//
//            println("count:${count}")
//
//            var head = dummy.next
//            for (i in 0 until count - index - 1) {
//                head = head.next
//            }
//            println("head:${head.`val`}")
//            head.next = head.next.next
//            return dummy.next


            /**
             * 双指针法
             */
//            var dummy = ListNode(0, node)
//            var first = node
//            var last = dummy
//
//            for (i in 0 until index) {
//                first = first.next
//            }
//
//            while (first != null) {
//                last = last.next
//
//                if (first.next == null) break
//                first = first.next
//            }
//
//            last.next = last.next.next
//
//            return dummy.next


            /**
             * 使用栈删除链表倒数第n个节点
             */
            var dummy = ListNode(0, node)
            var stack: Deque<ListNode> = LinkedList()
            var head = node
            while (head != null) {
                stack.push(head)
                if (head.next == null) break
                head = head.next
            }



            for (i in 0 until index) {
                stack.pop()
            }
            var cur: ListNode = stack.peekFirst()
            cur.next = cur.next.next
            return dummy.next

        }


        /**
         * 删除链表节点
         */
        fun deleteNode(node: ListNode) {
            node.`val` = node.next.`val`
            node.next = node.next.next
        }


        /**
         * 链表反转
         *
         */
        fun reverseList(head: ListNode) : ListNode {
//            var prev : ListNode? = null
//            var cur = head
//
//            while (cur != null) {
//                var next = cur.next
//                cur.next = prev
//                prev = cur
//                if (next == null) {
//                    return prev
//                }
//                cur = next
//            }
//
//            return prev?:ListNode(0)


            // 1-2-3-4-5
            // 1-2-3 5-4

            if (head == null || head.next == null) {
                return head
            }

            var node = reverseList(head.next)
            head.next.next = head
            head.next = null

            return node

        }

        fun printList(head: ListNode?) {
            var head = head
            while (head != null) {
                print(head.`val`.toString() + " -> ")
                head = head.next
            }
            println("null")
        }
    }


}