package org.example.leetcode;

public class Day8 {
	
	public static void main(String[] args) {
		System.out.println(myAtoi("-+1"));
	}
	
	public static int myAtoi(String str) {
		if (str == null || str.length() == 0 || str.trim().length() == 0) return 0; 
		
		String trim = str.trim();
		if (trim.charAt(0) != '-' && trim.charAt(0) != '+' && trim.charAt(0) < '0' && trim.charAt(0) > '9') {
			return 0;
		}
		
		String num = "";
		boolean pre = false;
		
		if (trim.charAt(0) == '-' || trim.charAt(0) == '+') {
			if (trim.length() == 1) return 0;
			if (trim.charAt(0) == '-') pre = true;
			trim = trim.substring(1);
		}
		
		for (int i = 0; i < trim.length(); i++) {
			char at = trim.charAt(i);
			if (at >= '0' && at <= '9') {
				num+=at;
			} else {
				break;
			}
		}
		
		if (num.length() == 0) return 0;
		
		Integer ret = null;
		
		try {
			ret = Integer.valueOf(num);
		} catch (Exception e) {
			if (pre) 
				return 0x80000000;
			return 0x7fffffff;
		}
		
        return pre ? ret * -1 : ret;
    }
}
