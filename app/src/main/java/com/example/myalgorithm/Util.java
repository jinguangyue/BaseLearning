package com.example.myalgorithm;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Util {

    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     *
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     *
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     *
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     *
     * 链接：https://leetcode.cn/problems/merge-sorted-array
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int length = nums1.length;
        for (int i=0; i<n; i++) {
            nums1[length-n+i] = nums2[i];
        }

        Arrays.sort(nums1);

    }

    /**
     * 删除数组重复项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int a = 1,b=1;
        while (a < nums.length) {
            if (nums[a-1] != nums[a]) {
                nums[b] = nums[a];
                b++;

            }

            a++;
        }

        return b;
    }

    /**
     * 获取股票最大利润 12345
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int result = 0;

        for (int i=1; i<prices.length; i++) {
            if (prices[i-1] < prices[i]) {
                result += prices[i] - prices[i-1];
            }
        }
        return result;
    }

    public int singleNumber(int[] nums) {
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
        int length = nums.length;
        int result = nums[0];
        for (int i=1; i<length; i++) {
            result ^= nums[i];
        }

        return result;
    }

    /**
     * 两个数组的交集
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        int[] intersects = new int[nums1.length];
        int index = 0;

        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersects[index] = num;
                index++;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }

        return Arrays.copyOfRange(intersects, 0, index);
    }
}
