package org.example.leetcode;

public class Day38 {
	public static void main(String[] args) {
		System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
	}
	
	public static int searchInsert(int[] nums, int target) {
		
		if (null == nums || nums.length == 0) return 0;
		
		if (nums.length == 1) {
			return nums[0] ==  target || nums[0] > target ? 0 : 1;
		}
		
		for (int i = 0; i < nums.length ; i++) {
			if (nums[i] == target || nums[i] > target) {
				return i;
			}
			
			if (i == nums.length-1) {
				return nums.length;
			}
		}
		
		return 0;
	
	}	
	
}
