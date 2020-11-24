package org.example.jzoffer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class JZ16 {

    public static void main(String[] args) {


    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) return null;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode node = new ListNode(-1);
        ListNode root = node;
        while (list1.next != null && list2.next != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1.next != null) {
            node.next = list1.next;
        }
        if (list2.next != null) {
            node.next = list2.next;
        }
        return root.next;
    }
}
