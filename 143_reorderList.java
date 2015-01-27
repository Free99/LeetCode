/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head==null || head.next==null) {
            return;
        }
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next!=null && runner.next.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode head1 = head;
        ListNode head2 = walker.next;
        walker.next = null;
        head2 = reverse(head2);
        while (head1!=null && head2!=null) {
            ListNode next = head2.next;
            head2.next = head1.next;
            head1.next = head2;
            head1 = head2.next;
            head2 = next;
        }
     }
     private ListNode reverse(ListNode head) {
         ListNode pre = null;
         ListNode cur = head;
         while(cur!=null) {
             ListNode next = cur.next;
             cur.next = pre;
             pre = cur;
             cur = next;
         }
         return pre;
     }
}