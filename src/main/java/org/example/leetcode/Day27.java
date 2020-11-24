package org.example.leetcode;

public class Day27 {
	public static void main(String[] args) {
		int[] nums = new int[]{2,0,1,2,2,3,0,4,2};
		int len = removeElement(nums,2);
		System.out.println(len+"=========");
		for (int i = 0; i < len; i++) {
		    System.out.println((nums[i]));
		}
	}
	
	
	public static int removeElement(int[] nums, int val) {
//		if (nums == null || nums.length == 0) return 0;
//		
//		int len = nums.length;
//		for (int i = len - 1; i >= 0; i--) {
//			if (nums[i] == val) {
//				for (int j = i; j < len -1; j++) {
//					int temp ;
//					temp = nums[j];
//					nums[j] = nums[j+1];
//					nums[j+1] = temp;
//				}
//				len--;
//			}
//		}
//        return len;
		
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[j] = nums[i];
				j++;
			}
		}
        return j;
	}
}
