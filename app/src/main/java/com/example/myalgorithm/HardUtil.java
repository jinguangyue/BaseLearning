package com.example.myalgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class HardUtil {



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



}



















