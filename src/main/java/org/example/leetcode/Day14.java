package org.example.leetcode;

public class Day14 {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
	}
	
	public static String longestCommonPrefix(String[] strs) {
//		if (null == strs || strs.length == 0) {
//			return "";
//		}
//		
//		if (strs.length == 1) {
//			return strs[0];
//		}
//		
//		StringBuffer sb = new StringBuffer();
//		String str0 = strs[0];
//		outer: 
//		for (int i = 0; i < str0.length(); i++) {
//			char c = str0.charAt(i);
//			for (int j = 1; j < strs.length; j++) {
//				if (i > strs[j].length() - 1) {
//					break outer;
//				}
//				
//				if (c != strs[j].charAt(i)) {
//					break outer;
//				}
//			}
//			sb.append(c);
//		}
//        return sb.toString();
		
		if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        String pre = strs[0];
        int  i = 0;
        while (i < strs.length)
        {
            while (strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length() - 1);
            i++;
        }
        return pre;
    }
}
