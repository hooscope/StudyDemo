package com.example.studyDemo.leetcode;

import java.util.*;

/**
 * @Author: hao wu
 * @Date： 2023/1/13 22:26
 */
public class HashClass {


    public static void main(String[] args) {

    }

    /**
     * 242. 有效的字母异位词
     */
    private boolean isAnagram(String s, String t) {

        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;     // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int count : record) {
            if (count != 0) {               // record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
                return false;
            }
        }
        return true;
    }

    /**
     * 349. 两个数组的交集
     */
    private static int[] intersection(int[] nums1, int[] nums2) {

        int[] res = new int[1000];
        for (int n1 : nums1) {
            res[n1] = 1;
        }
        List<Integer> out = new ArrayList<>();
        for (int n2 : nums2) {
            if (res[n2] == 1 && !out.contains(n2)) {
                out.add(n2);
            }
        }
        int[] outInt = new int[out.size()];
        for (int i = 0; i < out.size(); i++) {
            outInt[i] = out.get(i);
        }
        return outInt;
    }

    /**
     * 202. 快乐数
     */
    private static boolean isHappy(int n) {

        //set防止遇到重复的数导致无限循环
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNumber(n);
        }
        return n == 1;

    }

    private static int getNextNumber(int n) {
        //求n的每位平方和
        int res = 0;
        while (n > 0) {
            int low = n % 10;
            res += low * low;
            n = n / 10;
        }
        return res;
    }

    /**
     * 1. 两数之和
     */
    private static int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[0] = i;
                res[1] = map.get(temp);
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    /**
     * 454. 四数相加 II
     */
    private static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int count = 0;

        for (int k = 0; k < nums3.length; k++) {
            for (int l = 0; l < nums4.length; l++) {
                int sum = -(nums3[k] + nums4[l]);
                if (map.containsKey(sum)) {
                    count += map.get(sum);
                }
            }
        }
        return count;
    }

    /**
     * 383. 赎金信
     */
    private static boolean canConstruct(String ransomNote, String magazine) {

        int[] alphabet = new int[26];
        for (char ch : magazine.toCharArray()) {
            int index = ch - 'a';
            alphabet[index] += 1;
        }
        for (char ch : ransomNote.toCharArray()) {
            int index = ch - 'a';
            if (alphabet[index] == 0) {
                return false;
            } else {
                alphabet[index] -= 1;
            }
        }
        return true;
    }

    /**
     * 15. 三数之和
     */
    private static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return res;
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //内循环中去重
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    while (left < right && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;
    }

    /**
     * 18. 四数之和
     */
    private static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //target可能是负数，所以要在nums[i]>0的条件下剪枝
            if (nums[i] > 0 && nums[i] > target) return res;
            // 对nums[i]去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                // 对nums[j]去重
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }

                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //内循环中去重
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        while (left < right && nums[left] == nums[left + 1]) left++;

                        right--;
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;

    }
}
