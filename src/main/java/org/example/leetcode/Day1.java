package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target. You may assume that each input would have
 * exactly one solution. 
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * 			Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 *
 */
public class Day1 {

	//test
	public static void main(String[] args) {
		int[] nums = { 2, 5, 7, 1 };
		int[] twoSum = twoSum(nums, 7);
		for (int i = 0; i < twoSum.length; i++) {
			System.out.println(twoSum[i]);
		}
	}

	/*public static int[] towSum(int[] nums,int target){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0;i<nums.length;i++) {
			map.put(nums[i], i);
		}
		for (int i = 0;i<nums.length;i++) {
			if (map.containsKey(target-nums[i])) {
				return new int[]{i,map.get(target-nums[i])};
			}
		}
		return null;
	}*/
	
	public static int[] twoSum(int[] numbers, int target) {
	    int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i ;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i);
	    }
	    return result;
	}
	
}
