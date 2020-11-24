package org.example.leetcode;

public class Day28 {
	
	public static void main(String[] args) {
		System.out.println(strStr("mississippi", "issip"));
	}
	
	public static int strStr(String haystack, String needle) {
		if (needle == null || haystack == null || haystack.length() < needle.length()) return -1;
		if ("".equals(needle)) return 0;
		
		int j = 0;
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				if (j == needle.length() - 1) {
					return i - needle.length() + 1;
				}
				j++;
			} else {
				i = i - j;
				j = 0;
			}
		}
        return -1;
    }
}
