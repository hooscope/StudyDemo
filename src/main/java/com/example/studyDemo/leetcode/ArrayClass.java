package com.example.studyDemo.leetcode;


/**
 * 数组类题目
 * 二分法、双指针法、滑动窗口
 * */
public class ArrayClass {

    public static void main(String[] args) {
//        int[] nums = new int[]{-1,0,3,5,9,12};
//        int target = 2;
//        System.out.println(binarySearch(nums, target));

//        int[] nums = new int[]{2};
//        int target = 2;
//        System.out.println(removeElement(nums, target));

//        System.out.println(StrUtil.join(",", sortedSquares(new int[]{-4, -1, 0, 3, 10})));

//        int[] nums = new int[]{1, 2, 3, 4, 5};
//        int target = 11;
//        System.out.println(minSubArrayLen(target, nums));

        int[][] matrix = generateMatrix(5);
        for (int i=0;i<matrix.length;i++){
            String row = "";
            for (int j=0;j<matrix[i].length;j++){
                row = row.concat(String.valueOf(matrix[i][j])).concat(",");
            }
            System.out.println(row);
        }

    }


    /**
     * 704. 二分查找
     * 循环不变量原则，左闭右开，o(logn)
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
     * 快慢指针,o(n)
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
     * 双指针o(n)，平方最大的数值在两端
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

    /**
     * 209. 长度最小的子数组
     * 滑动窗口：双指针,o(n)
     */
    private static int minSubArrayLen(int target, int[] nums) {

        int res = Integer.MAX_VALUE;
        int i = 0;

        int sum = 0;
        for (int j = 0; j < nums.length; j++) {

            sum += nums[j];
            while (sum >= target) {
                res = Math.min(j - i + 1, res);
                sum -= nums[i++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;

    }

    /**
     * 59. 螺旋矩阵 II
     * 循环不变量，左闭右开区间，长度n-1 [ )
     */
    private static int[][] generateMatrix(int n) {

        int loop = 0; //循环圈数
        int i, j;
        int startX = 0, startY = 0;
        int offset = 1;
        int count = 1;
        int[][] res = new int[n][n];
        while (loop++ < n / 2) {

            //从左到右
            for (j = startX; j < n - offset; j++) {
                res[startY][j] = count++;
            }
            //从上到下
            for (i = startY; i < n - offset; i++) {
                res[i][j] = count++;
            }
            //从右到左
            for (; j > startX; j--) {
                res[i][j] = count++;
            }
            //从下到上
            for (; i > startY; i--) {
                res[i][j] = count++;
            }
            offset++;
            startX++;
            startY++;

        }

        if (n % 2 == 1) {
            res[startX][startY] = count;
        }

        return res;

    }
}
