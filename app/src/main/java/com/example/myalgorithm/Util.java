package com.example.myalgorithm;

import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class Util {


    /**
     * 快速排序
     * @param arr
     * @param low
     * @param high
     */
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 获取划分位置，左边元素小于基准，右边元素大于基准
            int pivotIndex = partition(arr, low, high);

            // 对基准左右两部分进行递归排序
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        System.out.println("jinguangyue-low " + low);
        System.out.println("jinguangyue-high " + high);
        System.out.println("jinguangyue-pivot " + pivot);
        printArray(arr);
        System.out.println();

        int left = low + 1;
        int right = high;

        while (left <= right) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }

            while (left <= right && arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
            }
        }
        System.out.println("jinguangyue-right " + right);
        printArray(arr);
        System.out.println();

        // low 是基准 把right放在基准位置上 因为经过左右递进之后 right 的位置左侧都是小于基准的 右侧都是大于基准的
        swap(arr, low, right);
        printArray(arr);
        System.out.println();


        return right;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + "-");
        }
    }

    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * <p>
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * <p>
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     * <p>
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     * <p>
     * 链接：https://leetcode.cn/problems/merge-sorted-array
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int length = nums1.length;
        for (int i = 0; i < n; i++) {
            nums1[length - n + i] = nums2[i];
        }

        Arrays.sort(nums1);

    }

    /**
     * 删除数组重复项
     * 122356
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int a = 1, b = 1;
        while (a < nums.length) {
            if (nums[a - 1] != nums[a]) {
                nums[b] = nums[a];
                b++;

            }

            a++;
        }

        printArray(nums);


        return b;
    }

    /**
     * 数组重复元素
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int nums[]) {
//        Arrays.sort(nums);
//        for (int i=0; i<nums.length - 1; i++) {
//            if (nums[i] == nums[i+1]) {
//                return true;
//            }
//        }
//
//        return false;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }

        return false;
    }

    /**
     * 获取股票最大利润 12345
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                result += prices[i] - prices[i - 1];
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
        for (int i = 1; i < length; i++) {
            result ^= nums[i];
        }

        return result;
    }

    /**
     * 两个数组的交集
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
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

    /**
     * 旋转数组
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        // 1234567 7654321 3  (i + k) % n
//        k %= nums.length;
//        reverse(nums, 0, nums.length - 1);
//        reverse(nums, 0, k - 1);
//        reverse(nums, k, nums.length - 1);


        int[] newArry = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArry[(i + k) % nums.length] = nums[i];
        }

        System.arraycopy(newArry, 0, nums, 0, nums.length);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    /**
     * 数组加一算法
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * 移动0的元素到末尾 [0, 1, 0, 3, 12]
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }

        int i = 0;
        int j = 0;

        while (i < n) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
            i++;
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
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i != map.get(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }

        return null;
    }


    /**
     * 数独有效性验证
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
//        int[][] rows = new int[9][9];
//        int[][] columes = new int[9][9];
//        int[][][] subboxs = new int[3][3][9];
//        for (int i=0; i<9; i++) {
//            for (int j=0; j<9; j++) {
//                char c = board[i][j];
//                if (c != '.') {
//                    int index = c - '0' - 1; // 表示数组下标
//                    rows[i][index]++;
//                    columes[j][index]++;
//                    subboxs[i/3][j/3][index]++;
//                    if (rows[i][index] > 1 || columes[j][index] > 1 || subboxs[i/3][j/3][index] > 1) {
//                        return false;
//                    }
//                }
//            }
//        }
//
//        return true;

        int[] rows = new int[10];
        int[] columes = new int[10];
        int[] boxs = new int[10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1; // 表示数组下标
                    // 0 3 6   0 1 2
                    int idx = i / 3 * 3 + j / 3;
                    if ((rows[i] >> index & 1) == 1 || (columes[j] >> index & 1) == 1 || (boxs[idx] >> index & 1) == 1) {
                        return false;
                    }

                    rows[i] |= (1 << index);
                    columes[j] |= (1 << index);
                    boxs[idx] |= (1 << index);

                }
            }
        }

        return true;
    }

    /**
     * 矩阵旋转 90度 关键点在于找到规律
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
//        int n = matrix.length;
//        int[][] matrixNew = new int[n][n];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                matrixNew[j][n - i - 1] = matrix[i][j];
//            }
//        }
//
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                matrix[i][j] = matrixNew[i][j];
//            }
//        }

//        int n = matrix.length;
//        for (int i=0; i<n/2; i++) {
//            for (int j=0; j<(n+1)/2; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[n - j - 1][i];
//                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
//                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
//                matrix[j][n - i - 1] = temp;
//            }
//        }

        /**
         * 先水平翻转一发
         */
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * 字符串翻转
     *
     * @param s
     */
    private void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 整数翻转
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
//        boolean isFu = false;
//        if (x < 0) {
//            isFu = true;
//            x = Math.abs(x);
//        }
//        String intStr = String.valueOf(x);  // 将 int 转换为字符串
//
//        int[] intArray = new int[intStr.length()];  // 创建数组，大小为字符串的长度
//
//        for (int i = 0; i < intStr.length(); i++) {
//            intArray[i] = Character.getNumericValue(intStr.charAt(i));  // 将字符转换为数字并存储在数组中
//        }
//
//        int start = 0;
//        int end = intArray.length - 1;
//        while (start < end) {
//            int temp = intArray[start];
//            intArray[start] = intArray[end];
//            intArray[end] = temp;
//            start++;
//            end--;
//        }
//
//        String result = "";
//
//        for (int i=0; i<intArray.length; i++) {
//            result += intArray[i];
//        }
//        int resultInt = 0;
//        try {
//            resultInt = Integer.parseInt(result);
//        } catch (Exception e) {
//            return resultInt;
//        }
//
//        if (isFu) {
//            return - resultInt;
//        }
//
//        return resultInt;


        int result = 0;
        while (x != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }

            int temp = x % 10;
            x = x / 10;
            result = result * 10 + temp;
        }

        return result;
    }

    /**
     * 第一个不重复的字符
     *
     * @param s
     * @return
     */
    private int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Set<Character> set = map.keySet();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }

        return -1;
    }


    /**
     * 有效的字母异位词
     *
     * @param s
     * @param t
     * @return
     */
    private boolean isAnagram(String s, String t) {

        /**
         * 自己写的
         */
//        if (s.length() != t.length()) {
//            return false;
//        }
//
//        Map<Character, Integer> maps = new HashMap<>();
//        for (int i=0; i<s.length(); i++) {
//            char c = s.charAt(i);
//            maps.put(c, maps.getOrDefault(c, 0) + 1);
//        }
//
//
//        for (int i=0; i<t.length(); i++) {
//            char c = t.charAt(i);
//            if (maps.containsKey(c)) {
//                Integer a = maps.getOrDefault(c, 0);
//                maps.put(c, a - 1);
//
//                if (a == 1) {
//                    maps.remove(c);
//                }
//            }
//        }
//
//        if (maps.size() == 0) {
//            return true;
//        }
//
//        return false;


        String temp = s + t;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character key : map.keySet()) {
            Integer value = map.get(key);
            if (value % 2 != 0) {
                return false;
            }
        }

        return true;


//        /**
//         * 看题解写的
//         */
//
//        if (s.length() != t.length()) {
//            return false;
//        }
//
//        int[] alpha = new int[26];
//        for (int i=0; i<s.length(); i++) {
//            char c = s.charAt(i);
//            char d = t.charAt(i);
//            alpha[c - 'a']++;
//            alpha[d - 'a']--;
//        }
//
//        for (int i=0; i<alpha.length; i++) {
//            if (alpha[i] != 0) {
//                return false;
//            }
//        }
//
//        return true;
    }

    /**
     * 验证回文串
     *
     * @param s
     * @return
     */
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            char str = Character.toLowerCase(s.charAt(start));
            char en = Character.toLowerCase(s.charAt(end));
            if ((str) != (en)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }


    /**
     * 字符串转换整数 atoi
     *
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int index = 0;
        if (length == 0) {
            return index;
        }
        while (index < length && chars[index] == ' ') {
            index++;
        }

        if (index == length) {
            return 0;
        }

        int sign = 1;
        if (chars[index] == '-') {
            sign = -1;
            index++;
        } else if (chars[index] == '+') {
            index++;
            sign = 1;
        }

        int res = 0;
        while (index < length) {
            char cur = chars[index];
            if (cur > '9' || cur < '0') {
                break;
            }

            if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && cur - '0' > -(Integer.MIN_VALUE % 10)) {
                return Integer.MIN_VALUE;
            } else if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && cur - '0' > Integer.MAX_VALUE % 10) {
                return Integer.MAX_VALUE;
            }

            res = res * 10 + sign * (cur - '0');
            index++;
        }

        return res;
    }

    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            int a = i;
            int b = 0;

            while (b < m && haystack.charAt(a) == needle.charAt(b)) {
                b++;
                a++;
            }

            if (b == m) {
                return i;
            }
        }

        return -1;
    }


    /**
     * kmp 寻找匹配串
     *
     * @param text
     * @param pattern
     * @return
     */
    public int kmpSearch(String text, String pattern) {
        int[] partialMatchTable = buildPartialMatchTable(pattern);
        int textIndex = 0; // 指向文本串
        int patternIndex = 0; // 指向模式串

        while (textIndex < text.length()) {
            if (text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                if (patternIndex == pattern.length() - 1) {
                    return textIndex - patternIndex; // 找到匹配，返回匹配的起始位置
                }
                textIndex++;
                patternIndex++;
            } else {
                if (patternIndex != 0) {
                    patternIndex = partialMatchTable[patternIndex - 1]; // 回退到部分匹配表的值
                } else {
                    textIndex++;
                }
            }
        }

        return -1; // 未找到匹配
    }

    /**
     * 构建匹配串
     *
     * @param pattern
     * @return
     */
    public static int[] buildPartialMatchTable(String pattern) {
        int[] table = new int[pattern.length()];
        int lengthOfPreviousLongestPrefixSuffix = 0; // 用于记录前一个位置的最长相同前缀后缀的长度

        for (int i = 1; i < pattern.length(); i++) {
            while (lengthOfPreviousLongestPrefixSuffix > 0
                    && pattern.charAt(i) != pattern.charAt(lengthOfPreviousLongestPrefixSuffix)) {
                lengthOfPreviousLongestPrefixSuffix = table[lengthOfPreviousLongestPrefixSuffix - 1]; // 回退到前一个位置的最长相同前缀后缀的长度
            }
            if (pattern.charAt(i) == pattern.charAt(lengthOfPreviousLongestPrefixSuffix)) {
                lengthOfPreviousLongestPrefixSuffix++; // 找到相同的字符，增加最长相同前缀后缀的长度
            }
            table[i] = lengthOfPreviousLongestPrefixSuffix;
        }

        return table;
    }


    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    /**
     * 删除链表倒数第n个元素-双指针法
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        ListNode last = dummy;

        while (first != null) {
            first = first.next;
            last = last.next;
        }

        last.next = last.next.next;
        ListNode result = dummy.next; // 头节点

        return result;
    }

    public ListNode removeNthFromEndForStack(ListNode head, int n) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur != null) {
            deque.push(cur);
            cur = cur.next;
        }

        for (int i = 0; i < n; i++) {
            deque.poll();
        }

        ListNode node = deque.peek();
        node.next = node.next.next;
        ListNode result = dummy.next;
        return result;
    }

    /**
     * 拿到链表长度删除倒数第n个节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndForLength(ListNode head, int n) {
        int length = getNodeLength(head);
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        for (int i = 0; i < length - n; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return dummy.next;
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = head;


        for (int i=1; i<m; i++) {
            pre = cur;
            cur = cur.next;
        }

        // pre = 1   cur = 2;

        for (int i=m; i<n; i++) {
            ListNode temp = cur.next; // 把3存下来
            cur.next = temp.next; // 2->4
            temp.next = pre.next; // 3-2-4
            pre.next = temp; // 1-3-2-4
        }

        return dummy.next;
    }


    private int getNodeLength(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        return length;
    }


    /**
     * 124
     * 134
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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

        ListNode prev = new ListNode(-1);
        ListNode preload = prev;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }

            prev = prev.next;

        }

        prev.next = (list1 == null) ? list2 : list1;
        return preload.next;

    }


    /**
     * 1-2-3-4-5-6
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {


//            ListNode prev = null;
//            ListNode current = head;
//
//            while (current != null) {
//                ListNode next = current.next;
//                current.next = prev;
//                prev = current;
//                current = next;
//            }
//            return prev;

        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        boolean result = true;
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfEnd = reverseList(firstHalfEnd.next);


        ListNode p1 = head;
        ListNode p2 = secondHalfEnd;

        while (result && p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        firstHalfEnd.next = reverseList(secondHalfEnd);

        return result;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fisrt = head;
        ListNode last = head;
        while (last.next != null && last.next.next != null) {
            fisrt = fisrt.next;
            last = last.next.next;
        }

        return fisrt;
    }

    public boolean hasCycle(ListNode head) {
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
            return false;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p1 != p2) {
            if (p2 == null || p2.next == null || p2.next.next == null) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }

        return true;

    }

    /**
     * 二叉树最大深度
     *
     * @return
     */
    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
////        if (root.left != null) {
////            Log.e("jinguangyue", "root.left===" + root.left.val);
////        }
//        int left = maxDepth(root.left);
////        Log.e("jinguangyue", "left===" + left);
////        if (root.right != null) {
////            Log.e("jinguangyue", "root.right===" + root.right.val);
////        }
//        int right = maxDepth(root.right);
////        Log.e("jinguangyue", "right===" + right);
//
//        int result = Math.max(left, right) + 1;
////        Log.e("jinguangyue", "result===" + result);
//        return result;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                size--;
            }
            ans++;
        }

        return ans;
    }

    /**
     * 有效二叉树判断
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long low, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= low || root.val >= upper) {
            return false;
        }

        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, upper);
    }


    /**
     * 递归方式判断对称二叉树
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }

    /**
     * 对称二叉树判断
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    /**
     * 使用队列迭代方式判断对称二叉树
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean check(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            if (node1 == null && node2 == null) {
                continue;
            }

            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }

            queue.offer(node1.left);
            queue.offer(node2.right);

            queue.offer(node1.right);
            queue.offer(node2.left);
        }

        return true;
    }

    /**
     * 使用队列做二叉树的层序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    level.add(node.val);

                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }

            result.add(level);
        }

        return result;
    }


    /**
     * 升序数组转换为平衡二叉树
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBst(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);

        return node;
    }

    /**
     * 使用二分法算出第一个错误的版本
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int num) {
        return num % 2 == 0;
    }

    public int climbStairs(int n) {
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = q + p;
        }

        return r;
    }


    /**
     * 买卖股票的最大利润，只能一天买，某一天卖的情况
     *
     * @param prices
     * @return
     */
    public int maxProfitOneDay(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }
        }

        return maxProfit;
    }

    /**
     * 最大自序的和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(pre, max);
        }

        return max;
    }


    /**
     * 动态规划解决打家劫舍问题
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {


//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//
//        for (int i=2; i<nums.length; i++) {
//            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
//        }
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }

        return second;
    }


    /**
     * 打乱数组
     * 打乱数组的算法在一些应用中是有很实际意义的，特别是在与随机性、模拟、和算法设计相关的领域。以下是一些常见的应用场景：
     * <p>
     * 随机化算法： 打乱数组常常被用在设计随机算法时，以确保算法的输出是随机的。例如，在随机化快速排序算法中，通过首先打乱数组，可以避免最坏情况的出现，使得算法的性能更加可预测。
     * <p>
     * 模拟实验： 在模拟实验中，如果你希望模拟一种随机的排列或分布，打乱数组是一种常见的手段。例如，在模拟粒子扩散时，可以使用打乱数组来表示粒子的随机运动。
     * <p>
     * 游戏开发： 在游戏开发中，打乱数组可以用于创建随机的关卡布局、卡牌游戏中洗牌等情景。通过打乱数组，可以为玩家提供更具挑战性和娱乐性的游戏体验。
     * <p>
     * 密码学： 在密码学中，如果需要生成随机的密钥或初始化向量，可以使用打乱数组的方法。
     * <p>
     * 在上面提到的打乱数组的实现中，使用的是 Fisher-Yates 洗牌算法，这是一种被广泛接受的高效而简单的打乱数组的方法。这个算法的主要思想是从数组的末尾开始，随机选择一个位置，然后将该位置的元素与当前位置的元素进行交换。这个过程一直持续到数组的开头。这种方法是线性时间的，非常适合打乱数组。
     */
    class Solution {
        int[] nums;
        int[] original;

        public Solution(int[] nums) {
            this.nums = nums;
            this.original = new int[nums.length];
            System.arraycopy(nums, 0, original, 0, nums.length);
        }

        public int[] reset() {
            System.arraycopy(original, 0, nums, 0, original.length);
            return nums;
        }

        public int[] shuffle() {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }

//            int[] results = new int[nums.length];
            Random random = new Random();
            for (int j = 0; j < nums.length; j++) {
//                int a = random.nextInt(list.size());
//                results[j] = list.remove(a);

                int a = j + random.nextInt(nums.length - j);
                int temp = nums[j];
                nums[j] = nums[a];
                nums[a] = temp;
            }

//            System.arraycopy(results, 0, nums, 0, results.length);
            return nums;
        }
    }


    /**
     * 二叉树层次遍历
     * @param root
     */
    public void leverOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()){
            TreeNode node = deque.poll();
            if (node == null) {
                return;
            }

            if (node.left != null) {
                deque.offer(node.left);
            }

            if (node.right != null) {
                deque.offer(node.right);
            }
        }
    }


    /**
     * 二叉树翻转
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


    /**
     * 不使用递归二叉树翻转
     * @param root
     * @return
     */
    public TreeNode invertTreeForQuene(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode current = queue.poll();

            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return root;
    }


}



















