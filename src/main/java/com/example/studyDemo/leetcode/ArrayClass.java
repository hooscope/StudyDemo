package com.example.studyDemo.leetcode;

public class ArrayClass {

    public static void main(String[] args) {
//        int[] nums = new int[]{-1,0,3,5,9,12};
//        int target = 2;
//        System.out.println(binarySearch(nums, target));

        int[] nums = new int[]{2};
        int target = 2;
        System.out.println(removeElement(nums, target));

    }


    private static int binarySearch(int[] nums, int target) {

        int left = 0, right = nums.length; //[left,right)
        while (left < right) {
            int index = left + (right - left) / 2;
            if (nums[index] > target) {
                right = index;
            } else if (nums[index] < target) {
                left = index+1;
            } else {
                return index;
            }
        }
        return -1;
    }

    private static int removeElement(int[] nums, int target) {

        int slowIndex = 0;
        for (int fastIndex = 0;fastIndex < nums.length;fastIndex++){
            if (nums[fastIndex] != target){
                nums[slowIndex]=nums[fastIndex];
                slowIndex++;
            }
            printNums(nums);
        }
        return slowIndex;
    }

    private static void printNums(int[] nums){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i:nums){
            sb.append(i).append(", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
