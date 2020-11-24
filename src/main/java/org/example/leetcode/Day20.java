package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 注意空字符串可被认为是有效字符串。
 */
public class Day20 {

	public static void main(String[] args) {
		System.out.println(isValid("(("));
	}
	
	public static boolean isValid(String s) {
		
		if (null == s ) return false;
		if (s.length() == 0) return true;
		if (s.length() % 2 != 0) return false;
		
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				stack.push(s.charAt(i));
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				Character pop = stack.pop();
				if (null == pop || null == map.get(pop) || !map.get(pop).equals(s.charAt(i))) {
					return false;
				}
			}
			
		}
		
		return stack.isEmpty();  
	}
	
}
