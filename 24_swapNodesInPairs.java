/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode probe = cur.next;
        while (probe!=null && probe.next!=null) {
            cur.next = probe.next;
            probe.next = probe.next.next;
            cur.next.next = probe;
            cur = probe;
            probe = probe.next;
        }
        return dummyHead.next;
    }
}


public class Solution {
    public ListNode swapPairs(ListNode head) {
        return rec(head);
    }
    
    public ListNode rec(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = p.next.next;
        p.next.next = p;
        ListNode newHead = p.next;
        p.next = rec(q);
        return newHead;
    }
}