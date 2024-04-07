package com.example.myalgorithm.treenode

import android.util.Log
import java.util.Deque
import java.util.LinkedList
import java.util.Queue


fun main() {

    var node1 = TreeNode(4)
    var node2 = TreeNode(5)
    var node3 = TreeNode(2, node1, node2)

    var node6 = TreeNode(6)
    var node7 = TreeNode(7)
    var node4 = TreeNode(3, node6, node7)
    var node5 = TreeNode(1, node3, node4)
//
    Log.e("jinguangyue", "levelOrder===" +  levelOrder(node5))
}


/**
 * 有效二叉树判断
 *
 * @param root
 * @return
 */
fun isValidBST(root: TreeNode?): Boolean {
    return if (root == null) {
        true
    } else isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
}

fun isValidBST(root: TreeNode?, low: Long, upper: Long): Boolean {
    if (root == null) {
        return true
    }
    return if (root.`val` <= low || root.`val` >= upper) {
        false
    } else isValidBST(root.left, low, root.`val`.toLong()) && isValidBST(
        root.right,
        root.`val`.toLong(),
        upper
    )
}


/**
 * 递归方式判断对称二叉树
 *
 * @param root1
 * @param root2
 * @return
 */
fun isSymmetric(root1: TreeNode?, root2: TreeNode?): Boolean {
    if (root1 == null && root2 == null) {
        return true
    }
    return if (root1 == null || root2 == null) {
        false
    } else root1.`val` == root2.`val` && isSymmetric(
        root1.left,
        root2.right
    ) && isSymmetric(root1.right, root2.left)
}

/**
 * 对称二叉树判断
 *
 * @param root
 * @return
 */
fun isSymmetric(root: TreeNode?): Boolean {
    return check(root!!, root)
}


/**
 * 使用队列迭代方式判断对称二叉树
 *
 * @param root1
 * @param root2
 * @return
 */
fun check(root1: TreeNode, root2: TreeNode): Boolean {
    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root1)
    queue.offer(root2)
    while (!queue.isEmpty()) {
        val node1 = queue.poll()
        val node2 = queue.poll()
        if (node1 == null && node2 == null) {
            continue
        }
        if (node1 == null || node2 == null || node1.`val` != node2.`val`) {
            return false
        }
        queue.offer(node1.left)
        queue.offer(node2.right)
        queue.offer(node1.right)
        queue.offer(node2.left)
    }
    return true
}


/**
 * 使用队列做二叉树的层序遍历
 *
 * 1
 * 2        3
 * 4    5   6     7
 *
 *
 *
 * @param root
 * @return
 */
fun levelOrder(root: TreeNode?): List<List<Int?>?>? {
    if (root == null) {
        return ArrayList()
    }
    val result: MutableList<List<Int?>?> = ArrayList()
    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root)
    var isReverse = false
    while (!queue.isEmpty()) {
        val lever = LinkedList<Int?>()
        val size = queue.size
        for (i in 0 until size) {
            val node = queue.poll()
            //                System.out.println("jinguangyue---levelOrder:" + node.val);
            Log.e("jinguangyue---levelOrder:", node.`val`.toString() + "")
            if (isReverse) {
                lever.addFirst(node.`val`)
            } else {
                lever.addLast(node.`val`)
            }
            //                lever.add(node.val);
            if (node.left != null) {
                queue.offer(node.left)
            }
            if (node.right != null) {
                queue.offer(node.right)
            }
        }
        result.add(lever)
        isReverse = !isReverse
    }
    return result
}


/**
 * 升序数组转换为平衡二叉树
 *
 * @param nums
 * @return
 */
fun sortedArrayToBst(nums: IntArray): TreeNode? {
    return helper(nums, 0, nums.size - 1)
}

fun helper(nums: IntArray, left: Int, right: Int): TreeNode? {
    if (left > right) {
        return null
    }
    val mid = (left + right) / 2
    val node = TreeNode(nums[mid])
    node.left = helper(nums, left, mid - 1)
    node.right = helper(nums, mid + 1, right)
    return node
}

/**
 * 二叉树层次遍历
 * @param root
 */
fun leverOrder(root: TreeNode) {
    val deque: Deque<TreeNode> = LinkedList()
    deque.offer(root)
    while (!deque.isEmpty()) {
        val node = deque.poll() ?: return
        if (node.left != null) {
            deque.offer(node.left)
        }
        if (node.right != null) {
            deque.offer(node.right)
        }
    }
}


/**
 * 二叉树翻转
 * @param root
 * @return
 */
fun invertTree(root: TreeNode): TreeNode? {
    val temp = root.left
    root.left = root.right
    root.right = temp
    invertTree(root.left)
    invertTree(root.right)
    return root
}


/**
 * 不使用递归二叉树翻转
 * @param root
 * @return
 */
fun invertTreeForQuene(root: TreeNode): TreeNode? {
    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root)
    while (!queue.isEmpty()) {
        val current = queue.poll()
        val temp = current.left
        current.left = current.right
        current.right = temp
        if (current.left != null) {
            queue.offer(current.left)
        }
        if (current.right != null) {
            queue.offer(current.right)
        }
    }
    return root
}


class UtilTreeNode {
}