/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode reverseBetween(ListNode a, int m, int n) {
	    if (m == n) {
	        return a;
	    }
	    ListNode dummy = new ListNode(-1);
	    dummy.next = a;
	    ListNode head = dummy;
	    int oldM = m;
	    while (m > 1) {
	        head = head.next;
	        m--;
	    }
	    ListNode tail = head.next;
	    head.next = null;
	    ListNode cur = tail;
	    ListNode pre = null;
	    while (n - oldM >= 0) {
	        ListNode next = cur.next;
	        cur.next = pre;
	        pre = cur;
	        cur = next;
	        n--;
	    }
	    head.next = pre;
	    tail.next = cur;
	    return dummy.next;
	    
	}
}