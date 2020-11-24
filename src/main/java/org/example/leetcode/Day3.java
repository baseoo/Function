package org.example.leetcode;

/**
 * 
 * Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 *	Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 *	Given "bbbbb", the answer is "b", with the length of 1.
 *
 *	Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 *
 */
public class Day3 {

	//test
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("fsdfvfdfdgqew"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) return 0;
		char[] ch = s.toCharArray();
		StringBuffer sb = null;
		int p = 0;// 开始位置
		int max = 0;// 最大长度
		while (p < ch.length) {
			int count = 0;
			sb = new StringBuffer();
			for (int i = p; i < ch.length; i++) {
				if (sb.toString().indexOf(ch[i]) == -1) {// 不包含
					count++;
					sb.append(ch[i]);// 添加下一个元素
					if (i != ch.length - 1) {
						continue;
					}
				}
				max = max > count ? max : count;
				p++;
				break;
			}
		}

		return max;
	}
}
