package org.example.leetcode;


/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class Day2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        int sum = 0;//节点的和
        int carry = 0;//进位值
        while (l1 != null || l2 != null || carry != 0) {
            int l11 = l1 == null ? 0 : l1.val;
            int l22 = l2 == null ? 0 : l2.val;

            sum = l11 + l22 + carry;
            carry = sum / 10;
            if (carry > 0) {//有进位
                head.next = new ListNode(sum % 10);
            } else {
                head.next = new ListNode(sum);
            }
            head = head.next;//指向下一个节点
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

        }

        return p.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


