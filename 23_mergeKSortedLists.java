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
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null || lists.size()==0) {
            return null;
        }
        return helper(lists, 0, lists.size()-1);
    }
    private ListNode helper(List<ListNode> lists, int l, int r) {
        if (l<r) {
            int m = l+((r-l)>>1);
            return merge(helper(lists, l, m), helper(lists, m+1, r));
        }
        return lists.get(l);
    }
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode cur = dummy;
        while (l1!=null && l2!=null) {
            if (l1.val<l2.val) {
                l1 = l1.next;
            } else {
                ListNode next = l2.next;
                cur.next = l2;
                l2.next = l1;
                l2 = next;
            }
            cur = cur.next;
        }
        if (l2!=null) {
            cur.next = l2;
        }
        return dummy.next;
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
    public ListNode mergeKLists(List<ListNode> lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10, new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.val-n2.val;
            }
        });
        for (int i=0; i<lists.size(); i++) {
            ListNode node = lists.get(i);
            if (node!=null) {
                heap.offer(node);
            }
        }
        ListNode head = null;
        ListNode pre = head;
        while(heap.size()>0) {
            ListNode cur = heap.poll();
            if (head==null) {
                head = cur;
                pre = head;
            } else {
                pre.next = cur;
            }
            pre = cur;
            if (cur.next!=null) {
                heap.offer(cur.next);
            }
        }
        return head;
    }
}