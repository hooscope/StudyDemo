package com.example.studyDemo.leetcode;

/**
 * @Author: hao wu
 * @Date： 2023/1/17 20:23
 */
public class StringClass {
    public static void main(String[] args) {

        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s, k));
        System.out.println(System.getProperty("java.io.tmpdir"));
    }

    /**
     * 344. 反转字符串
     */
    private static void reverseString(char[] s) {

        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 541. 反转字符串 II
     */
    private static String reverseStr(String s, int k) {


        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i += 2 * k) {
            if (i + k <= ch.length) {
                int left = i, right = i + k - 1;
                while (left < right) {
                    char temp = ch[left];
                    ch[left] = ch[right];
                    ch[right] = temp;
                    left++;
                    right--;
                }
                continue;
            }
            int left = i, right = ch.length - 1;
            while (left < right) {
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }

        }


        return String.valueOf(ch);

    }
}
