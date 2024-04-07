package com.example.myalgorithm.listnode

import com.example.myalgorithm.treenode.TreeNode
import java.util.Deque
import java.util.LinkedList
import java.util.Queue

class ListNodeUtil {
    companion object {

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


        /**
         * 第k个位置旋转
         */
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
            k %= length
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


        /**
         * 验证联编回文串
         * @param head
         * @return
         */
        fun isPalindrome(head: ListNode?): Boolean {
            if (head == null) {
                return true
            }
            var result = true
            val firstHalfEnd = endOfFirstHalf(head)
            val secondHalfEnd = reverseList(firstHalfEnd.next)
            var p1 = head
            var p2: ListNode? = secondHalfEnd
            while (result && p1 != null && p2 != null) {
                if (p1.`val` != p2.`val`) {
                    result = false
                }
                p1 = p1.next
                p2 = p2.next
            }
            firstHalfEnd.next = reverseList(secondHalfEnd)
            return result
        }

        private fun endOfFirstHalf(head: ListNode): ListNode {
            var fisrt = head
            var last = head
            while (last.next != null && last.next.next != null) {
                fisrt = fisrt.next
                last = last.next.next
            }
            return fisrt
        }

        fun hasCycle(head: ListNode?): Boolean {
//        Set<ListNode> set = new HashSet<>();
//        while (head != null) {
//            if (!set.add(head)) {
//                return true;
//            }
//            head = head.next;
//        }
//
//        return false;
            if (head == null) {
                return false
            }
            var p1: ListNode = head
            var p2 = head.next
            while (p1 !== p2) {
                if (p2 == null || p2.next == null || p2.next.next == null) {
                    return false
                }
                p1 = p1.next
                p2 = p2.next.next
            }
            return true
        }


        fun deleteNode(node: ListNode) {
            node.`val` = node.next.`val`
            node.next = node.next.next
        }


        /**
         * 删除链表倒数第n个元素-双指针法
         *
         * @param head
         * @param n
         * @return
         */
        fun removeNthFromEnd(
            head: ListNode?,
            n: Int
        ): ListNode? {
            val dummy =
                ListNode(0, head)
            var first = head
            for (i in 0 until n) {
                first = first!!.next
            }
            var last = dummy
            while (first != null) {
                first = first.next
                last = last.next
            }
            last.next = last.next.next
            return dummy.next
        }

        fun removeNthFromEndForStack(
            head: ListNode?,
            n: Int
        ): ListNode? {
            val deque: Deque<ListNode> =
                LinkedList()
            val dummy =
                ListNode(0, head)
            var cur: ListNode? = dummy
            while (cur != null) {
                deque.push(cur)
                cur = cur.next
            }
            for (i in 0 until n) {
                deque.poll()
            }
            val node = deque.peek()
            node.next = node.next.next
            return dummy.next
        }

        /**
         * 拿到链表长度删除倒数第n个节点
         *
         * @param head
         * @param n
         * @return
         */
        fun removeNthFromEndForLength(head: ListNode, n: Int): ListNode? {
            val length = getNodeLength(head)
            val dummy = ListNode(0, head)
            var cur = dummy
            for (i in 0 until length - n) {
                cur = cur.next
            }
            cur.next = cur.next.next
            return dummy.next
        }

        /**
         * 固定从m到n的链表翻转
         * 1-2-3-4-5
         * m = 2
         * n = 4
         * @param head
         * @param m
         * @param n
         * @return
         */
        fun reverseBetween(head: ListNode, m: Int, n: Int): ListNode? {
            val dummy = ListNode(0, head)
            var pre = dummy
            var cur = head
            for (i in 1 until m) {
                pre = cur
                cur = cur.next
            }

            // pre = 1   cur = 2;
            for (i in m until n) {
                val temp = cur.next // 把3存下来
                cur.next = temp.next // 2->4
                temp.next = pre.next // 3-2-4
                pre.next = temp // 1-3-2-4
            }
            return dummy.next
        }


        private fun getNodeLength(head: ListNode): Int {
            var length = 0
            var cur: ListNode? = head
            while (cur != null) {
                cur = cur.next
                length++
            }
            return length
        }

        /**
         * 124
         * 134
         *
         * @param list1
         * @param list2
         * @return
         */
        fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
//        if (list1 == null) {
//            return list2;
//        } else if (list2 == null) {
//            return list1;
//        } else if (list1.val <= list2.val) {
//            list1.next = mergeTwoLists(list1.next, list2);
//            return list1;
//        } else {
//            list2.next = mergeTwoLists(list2.next, list1);
//            return list2;
//        }
            var list1 = list1
            var list2 = list2
            var prev = ListNode(-1)
            val preload = prev
            while (list1 != null && list2 != null) {
                if (list1.`val` <= list2.`val`) {
                    prev.next = list1
                    list1 = list1.next
                } else {
                    prev.next = list2
                    list2 = list2.next
                }
                prev = prev.next
            }
            prev.next = list1 ?: list2
            return preload.next
        }


        fun levelOder(node: TreeNode): List<List<Int>> {
            var queue : Queue<TreeNode> = LinkedList()
            queue.add(node)

            var result = ArrayList<List<Int>>()

            while (!queue.isEmpty()){
                var level = ArrayList<Int>()
                var length = queue.size
                for (i in 0 until length) {
                    var treeNode = queue.poll()
                    level.add(treeNode.`val`)
                    if (treeNode.left != null) {
                        queue.add(treeNode.left)
                    }

                    if (treeNode.right != null) {
                        queue.add(treeNode.right)
                    }
                }

                result.add(level)
            }

            return result
        }


        /**
         * 合并两个有序链表
         */
        fun mergeListNodes(node1: ListNode?, node2: ListNode?) : ListNode? {
            /**
             * 递归排序两个有序链表
             */
//            return if (node1 == null) {
//                node2
//            } else if (node2 == null) {
//                node1
//            } else if (node1.`val` < node2.`val`) {
//                node1.next = mergeListNodes(node1.next, node2)
//                node1
//            } else {
//                node2.next = mergeListNodes(node1, node2.next)
//                node2
//            }


            /**
             * 循环 排序两个有序链表
             */
            var head1 = node1
            var head2 = node2

            var prev = ListNode(0)
            var dummy = ListNode(0, prev)

            while (head1 != null && head2 != null) {
                if (head1.`val` < head2.`val`) {
                    prev.next = head1
                    head1 = head1.next
                } else {
                    prev.next = head2
                    head2 = head2.next
                }

                prev = prev.next
            }

            if (head1 == null) {
                prev.next = head2
            } else {
                prev.next = head1
            }

            return dummy.next

        }


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