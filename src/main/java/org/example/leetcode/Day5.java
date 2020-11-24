package org.example.leetcode;

public class Day5 {

	public static void main(String[] args) {
//		System.out.println(isPalindrome("aabb"));
		System.out.println(longestPalindrome("aabb"));
	}
	
	public static String longestPalindrome(String s) {
		if (s == null || s.length() == 0) return null;
		if (s.length() == 1) return s;
		if (s.length() > 1000) return null;
		
		String ret = s.charAt(0) + "";
		for (int i = 0; i < s.length() - 1; i++) {
			char current = s.charAt(i);
			for (int j = s.length() - 1; j > i; j--) {
				if (s.charAt(j) == current) {
					String substring = s.substring(i, j + 1); 
					boolean palindrome = isPalindrome(substring);
					if (palindrome) {
						ret = substring.length() > ret.length() ? substring : ret;
						break;
					}
				}
			}
		}
		
        return ret;
    }
	
	public static boolean isPalindrome(String s){
		boolean flag = true;
		for (int i = 0,j = s.length() -1 - i; i< s.length(); i++,j--) {
			
			if (i >= j) {
				break;
			}
			
			if (s.charAt(i) != s.charAt(j)) {
				flag = false;
			}
			
		}
		return flag;
	}
  
}
