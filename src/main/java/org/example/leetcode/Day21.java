package org.example.leetcode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Day21 {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) return null;
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		ListNode ln = new ListNode(0);
		ListNode pre = ln;
		while(l2 != null && l1 != null) {
			if (l1.val <= l2.val) {
				pre.next = l1;
				l1 = l1.next;
			} else {
				pre.next = l2;
				l2 = l2.next;
			}
			
			pre = pre.next;

		}
		
		if(l1 != null) pre.next = l1;
		if(l2 != null) pre.next = l2;
		
		return ln.next;
        
    }
	
	 public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	 
	 public static void main(String[] args) {
		 
		ListNode l11 = new ListNode(1);
		ListNode l12 = new ListNode(2);
		ListNode l13 = new ListNode(4);
		l11.next = l12;
		l12.next = l13;
		
		ListNode l21 = new ListNode(1);
		ListNode l22 = new ListNode(3);
		ListNode l23 = new ListNode(4);
		
		l21.next = l22;
		l22.next = l23;
		ListNode node = new Day21().mergeTwoLists(l11,l21);
		while(node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		
	}
}
