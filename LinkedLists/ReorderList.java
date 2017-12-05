/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode reorderList(ListNode a) {
	    if (a == null || a.next == null || a.next.next == null) {
	        return a;
	    }
	    ListNode slow = a;
	    ListNode fast = a;
	    while (fast.next != null && fast.next.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    ListNode newHead = reverseList(slow.next);
	    slow.next = null;
	    ListNode head = a;
	    while (newHead != null) {
	        ListNode nextA = head.next;
	        ListNode nextB = newHead.next;
	        head.next = newHead;
	        newHead.next = nextA;
	        head = nextA;
	        newHead = nextB;
	    }
	    return a;
	}
	public ListNode reverseList(ListNode node) {
	    if (node == null || node.next == null) {
	        return node;
	    }
//	    ListNode head = node;
	    ListNode pre = null;
	    while (node != null) {
	        ListNode next = node.next;
	        node.next = pre;
	        pre = node;
	        node = next;
	    }
	    return pre;
	}
}