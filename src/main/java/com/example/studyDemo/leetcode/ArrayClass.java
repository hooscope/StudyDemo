package com.example.studyDemo.leetcode;

import cn.hutool.core.util.StrUtil;

public class ArrayClass {

    public static void main(String[] args) {
//        int[] nums = new int[]{-1,0,3,5,9,12};
//        int target = 2;
//        System.out.println(binarySearch(nums, target));

//        int[] nums = new int[]{2};
//        int target = 2;
//        System.out.println(removeElement(nums, target));

        System.out.println(StrUtil.join(",",sortedSquares(new int[]{-4, -1, 0, 3, 10})));

    }


    /**
     * 704. 二分查找
     */
    private static int binarySearch(int[] nums, int target) {

        int left = 0, right = nums.length; //[left,right)
        while (left < right) {
            int index = left + (right - left) / 2;
            if (nums[index] > target) {
                right = index;
            } else if (nums[index] < target) {
                left = index + 1;
            } else {
                return index;
            }
        }
        return -1;
    }

    /**
     * 27. 移除元素
     */
    private static int removeElement(int[] nums, int target) {

        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != target) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    /**
     * 977. 有序数组的平方
     */
    private static int[] sortedSquares(int[] nums) {

        int i = 0, j = nums.length - 1;
        int k = nums.length - 1;
        int[] res = new int[nums.length];
        while (i <= j) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                res[k--] = nums[j] * nums[j];
                j--;
            } else {
                res[k--] = nums[i] * nums[i];
                i++;
            }
        }
        return res;
    }

}
