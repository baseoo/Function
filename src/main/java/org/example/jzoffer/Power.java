package org.example.jzoffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 */
public class Power {

    public static void main(String[] args) {
        System.out.println(Power(2,-3));
    }

    public static double Power(double base, int exponent) {
        if (base == 0) {
            return 0L;
        }
        if (exponent == 0) {
            return 1;
        }
        boolean flag = false;
        if (exponent < 0) {
            flag = true;
        }
        int ep = Math.abs(exponent);
        double num = base;
        while (ep > 1) {
            num = num * base;
            ep--;
        }
        return flag ? 1/num : num;
    }
}
