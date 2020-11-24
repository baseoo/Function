package org.example.leetcode;

public class Day4 {
	
	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[]{2,3},new int[]{}));
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length == 0 && nums2.length == 0) return 0;
		int[] num = new int[nums1.length+nums2.length];
		
		int i = 0,j = 0,k = 0;
		while(i < nums1.length && j < nums2.length) {
			if (nums1[i] <= nums2[j]) {
				num[k++] = nums1[i++];
			} else {
				num[k++] = nums2[j++];
			}
		}
		
		
		while(i <= nums1.length -1) {
			num[k++] = nums1[i++];
		}
		
		while(j <= nums2.length-1) {
			num[k++] = nums2[j++];
		}
		
        return num.length % 2 == 0 ? (double)(num[num.length/2] + num[num.length/2-1])/2 : (double)num[num.length/2] ;
    }
}
