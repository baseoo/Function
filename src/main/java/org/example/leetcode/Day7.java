package org.example.leetcode;

/**
 * 
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 */
public class Day7 {
	public static void main(String[] args) {
		System.out.println(reverse(-44430));
		
	}
	
	public static int reverse(int x) {
		StringBuffer value = new StringBuffer();
		String pre = "";
		if (x == 0)  return 0;
		if (x < 0) {
			pre = "-";
		} 
		
		String source = Math.abs(x) + "";
		for (int i = source.length() - 1; i >= 0; i--) {
			value.append(source.charAt(i));
		}
		
		try {
			return Integer.valueOf(pre + value);
		} catch (Exception e) {
			return 0;
		}
		
    }
}
