package org.example.leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 */
public class Day9 {
	public static void main(String[] args) {
		System.out.println(isPalindrome(1223435466));
	}
	
	public static boolean isPalindrome(int x) {
		if (x < 0) return false;
		
		int value = 0;
		int temp = x;
		do {
			value = value * 10 + x % 10;
			x = x / 10 ;
		} while (x > 0);
		
		if (value == temp) return true; 
		
        return false;
    }
}
