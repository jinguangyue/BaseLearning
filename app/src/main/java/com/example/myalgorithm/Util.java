package com.example.myalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
     * 来源：力扣（LeetCode）
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
     * 获取股票最大利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

    }
}
