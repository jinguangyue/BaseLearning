package com.example.myalgorithm

class ListNodeUtil {
    companion object {

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