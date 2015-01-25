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
    public ListNode rotateRight(ListNode head, int n) {
        if (head==null) {
            return null;
        }
        ListNode walker = head;
        ListNode runner = head;
        int idx = 0;
        while (runner!=null && idx<n) {
            runner = runner.next;
            idx++;
        }
        if (runner==null) {
            n %= idx;
            runner = head;
            idx = 0;
            while (runner!=null && idx<n) {
                runner = runner.next;
                idx++;
            }
        }
        while (runner.next!=null) {
            walker = walker.next;
            runner = runner.next;
        }
        runner.next = head;
        ListNode newHead = walker.next;
        walker.next = null;
        return newHead;
    }
}