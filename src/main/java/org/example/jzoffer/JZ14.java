package org.example.jzoffer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class JZ14 {

    public static void main(String[] args) {

        ListNode node = new ListNode(2);
        FindKthToTail(node, 3);
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) return null;
        // 两个指针p1,p2，p1先走k步，然后一起走，当p1=null时，p2则是倒数第k个结点
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 1; i < k; i++) {
            if (p1.next == null) {
                return null;
            }
            p1 = p1.next;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
