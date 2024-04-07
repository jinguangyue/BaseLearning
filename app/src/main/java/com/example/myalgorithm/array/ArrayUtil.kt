package com.example.myalgorithm.array

import java.util.Arrays


fun main() {

}

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 *
 *
 * 链接：https://leetcode.cn/problems/merge-sorted-array
 *
 * @param nums1
 * @param m
 * @param nums2
 * @param n
 */
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    val length = nums1.size
    for (i in 0 until n) {
        nums1[length - n + i] = nums2[i]
    }
    Arrays.sort(nums1)
}

/**
 * 删除数组重复项
 * 122356
 *
 * @param nums
 * @return
 */
fun removeDuplicates(nums: IntArray): Int {
    var a = 1
    var b = 1
    while (a < nums.size) {
        if (nums[a - 1] != nums[a]) {
            nums[b] = nums[a]
            b++
        }
        a++
    }
    printArray(nums)
    return b
}


fun printArray(arr: IntArray) {
    for (num in arr) {
        print("$num-")
    }
}


/**
 * 数组重复元素
 *
 * @param nums
 * @return
 */
fun containsDuplicate(nums: IntArray): Boolean {
//        Arrays.sort(nums);
//        for (int i=0; i<nums.length - 1; i++) {
//            if (nums[i] == nums[i+1]) {
//                return true;
//            }
//        }
//
//        return false;
    val set: MutableSet<Int> = HashSet()
    for (i in nums.indices) {
        if (!set.add(nums[i])) {
            return true
        }
    }
    return false
}

/**
 * 获取股票最大利润 12345
 *
 * @param prices
 * @return
 */
fun maxProfit(prices: IntArray): Int {
    var result = 0
    for (i in 1 until prices.size) {
        if (prices[i - 1] < prices[i]) {
            result += prices[i] - prices[i - 1]
        }
    }
    return result
}

fun singleNumber(nums: IntArray): Int {
//        Arrays.sort(nums);
//        int length = nums.length;
//        if (length > 1) {
//            if (nums[0] != nums[1]) {
//                return nums[0];
//            }
//
//            if (nums[length - 2] != nums[length - 1]) {
//                return nums[length - 1];
//            }
//        } else {
//            return nums[0];
//        }
//        for (int i=2; i<nums.length; i++) {
//            if (nums[i-2] != nums[i-1] && nums[i-1] != nums[i]) {
//                return nums[i-1];
//            }
//        }
    val length = nums.size
    var result = nums[0]
    for (i in 1 until length) {
        result = result xor nums[i]
    }
    return result
}

/**
 * 两个数组的交集
 *
 * @param nums1
 * @param nums2
 * @return
 */
fun intersect(nums1: IntArray, nums2: IntArray): IntArray? {
    if (nums1.size > nums2.size) {
        intersect(nums2, nums1)
    }
    val map: MutableMap<Int, Int> = HashMap()
    for (num in nums1) {
        val count = map.getOrDefault(num, 0) + 1
        map[num] = count
    }
    val intersects = IntArray(nums1.size)
    var index = 0
    for (num in nums2) {
        var count = map.getOrDefault(num, 0)
        if (count > 0) {
            intersects[index] = num
            index++
            count--
            if (count > 0) {
                map[num] = count
            } else {
                map.remove(num)
            }
        }
    }
    return Arrays.copyOfRange(intersects, 0, index)
}

/**
 * 旋转数组
 *
 * @param nums
 * @param k
 */
fun rotate(nums: IntArray, k: Int) {
    // 1234567 7654321 3  (i + k) % n
//        k %= nums.length;
//        reverse(nums, 0, nums.length - 1);
//        reverse(nums, 0, k - 1);
//        reverse(nums, k, nums.length - 1);
    val newArry = IntArray(nums.size)
    for (i in nums.indices) {
        newArry[(i + k) % nums.size] = nums[i]
    }
    System.arraycopy(newArry, 0, nums, 0, nums.size)
}

private fun reverse(nums: IntArray, start: Int, end: Int) {
    var start = start
    var end = end
    while (start < end) {
        val temp = nums[start]
        nums[start] = nums[end]
        nums[end] = temp
        start++
        end--
    }
}


/**
 * 数组加一算法
 *
 * @param digits
 * @return
 */
fun plusOne(digits: IntArray): IntArray? {
    var digits = digits
    for (i in digits.indices.reversed()) {
        if (digits[i] == 9) {
            digits[i] = 0
        } else {
            digits[i] += 1
            return digits
        }
    }
    digits = IntArray(digits.size + 1)
    digits[0] = 1
    return digits
}

/**
 * 移动0的元素到末尾 [0, 1, 0, 3, 12]
 *
 * @param nums
 */
fun moveZeroes(nums: IntArray) {
    val n = nums.size
    if (n <= 1) {
        return
    }
    var i = 0
    var j = 0
    while (i < n) {
        if (nums[i] != 0) {
            val temp = nums[j]
            nums[j] = nums[i]
            nums[i] = temp
            j++
        }
        i++
    }
}


/**
 * [3, 2, 4] target=6
 * 两数之和
 *
 * @param nums
 * @param target
 * @return
 */
fun twoSum(nums: IntArray, target: Int): IntArray? {
    val map: MutableMap<Int, Int> = HashMap()
    for (i in nums.indices) {
        if (map.containsKey(nums[i]) && i != map[nums[i]]) {
            return intArrayOf(map[nums[i]]!!, i)
        }
        map[target - nums[i]] = i
    }
    return null
}


class ArrayUtil {



}