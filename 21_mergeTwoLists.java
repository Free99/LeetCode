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
public class Soulution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode mergeDM = new ListNode(0);
		ListNode dmHead = mergeDm;
		ListNode l1head = l1, l2head = l2;
		while(l1head != null && l2head != null) {
			if (l1head.val <= l2head.val) {
				dmHead.next = new ListNode(l1head.val);
				l1head = l1head.next;
			} else {
				dmHead.next = new ListNode(l2head.val);
				l2head = l2head.next;
			}
			dmHead = dmHead.next;
		}

		while(l1head != null) {
			dmHead.next = new ListNode(l1head.val);
			l1head = l1head.next;
			dmHead = dmHead.next;
		}

		while(l2head != null) {
			dmHead.next = new ListNode(l2head.val);
			l2head = l2head.next;
			dmHead = dmHead.next;
		}

		return mergeDm.next;
	}
}