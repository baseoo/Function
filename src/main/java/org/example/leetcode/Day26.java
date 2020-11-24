package org.example.leetcode;


public class Day26 {

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) return 0; 
		
//		int len = nums.length;
//		for (int i = len - 1; i > 0; i--) {
//			if (nums[i] == nums[i-1]) {
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
		
		int j = 1;
		for (int i = 1;i<nums.length;i++) {
			if (nums[i] != nums[i-1]) {
				nums[j] = nums[i];
				j++;
			}
		}
		return j;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,1,2};
		int len = removeDuplicates(nums);
		System.out.println(len);
		for (int i = 0; i < len; i++) {
		    System.out.println((nums[i]));
		}
	}
}
