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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null) {
            return null;
        }
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        int cnt = Math.abs(lenA-lenB);
        if (lenA > lenB) {
            while (cnt > 0) {
                headA = headA.next;
                cnt--;
            }
        } else {
            while (cnt > 0) {
                headB = headB.next;
                cnt--;
            }
        }
        
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    private int getLen(ListNode head) {
        int cnt = 0;
        while (head != null) {
            head = head.next;
            cnt++;
        }
        return cnt;
    }
}


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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        ListNode tailA = null;
        ListNode tailB = null;
        
        while (true) {
            if (pA == null) {
                pA = headB;
            }
            if (pB == null) {
                pB = headA;
            }
            if (pA.next == null) {
                tailA = pA;
            }
            if (pB.next == null) {
                tailB = pB;
            }
            if (tailA != null && tailB != null && tailA != tailB) {
                return null;
            }
            if (pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }
    }
}