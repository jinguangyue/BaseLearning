package com.example.myalgorithm

class ListNodeUtil {
    companion object {

        /**
         * 链表反转
         *
         */
        fun reverseList(head: ListNode) : ListNode {
            var prev : ListNode? = null
            var cur = head

            while (cur != null) {
                var next = cur.next
                cur.next = prev
                prev = cur
                if (next == null) {
                    return prev
                }
                cur = next
            }

            return prev?:ListNode(0)
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