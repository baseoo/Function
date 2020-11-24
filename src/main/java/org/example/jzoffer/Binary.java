package org.example.jzoffer;

/**
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 */
public class Binary {

    public static void main(String[] args) {

        System.out.println(number(8));

        System.out.println("Hello, World!");
    }

    public static int number(int num) {
        String binaryString = Integer.toBinaryString(num);
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);
            if ((c+"").equals("1")) {
                count++;
            }
        }
        System.out.println(binaryString);
        return count;
    }

}
