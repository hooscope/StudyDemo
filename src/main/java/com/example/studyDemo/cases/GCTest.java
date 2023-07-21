package com.example.studyDemo.cases;

/**
 * @Author: hao wu
 * @Date： 2023/1/31 22:30
 */
public class GCTest {

    public static void main(String[] args) {
//        byte[] allocation1, allocation2,allocation3,allocation4,allocation5;
//        allocation1 = new byte[52000*1024];
//        allocation2 = new byte[12000*1024];
//        allocation3 = new byte[1000*1024];
//        allocation4 = new byte[1000*1024];
//        allocation5 = new byte[1000*1024];

        int reverse = reverse(-Integer.MAX_VALUE);
        System.out.println(reverse);

    }
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

}
