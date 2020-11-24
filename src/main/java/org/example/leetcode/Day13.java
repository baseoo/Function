package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;


/**
 * 罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 */
public class Day13 {
	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV"));
	}
	
	public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        
        if (null == s || s.isEmpty()) {
        	return 0;
        }
        
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
        	Integer curr = map.get(s.charAt(i) + "");
        	
        	if (i < s.length() - 1) {
        		if (curr < map.get(s.charAt(i+1) + "")) {
        			curr = curr * -1;
        		}
        	}
        	sum += curr;
        }
		return sum;
    }

}
