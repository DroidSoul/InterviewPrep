/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode a, ListNode b) {
	    ListNode dummy = new ListNode(-1);
	    ListNode head = dummy;
	    int carry = 0;
	    while (a != null || b != null || carry != 0) {
	        int sum = (a == null ? 0 : a.val) + (b == null ? 0 : b.val) + carry;
	        carry = sum / 10;
	        sum %= 10;
	        head.next = new ListNode(sum);
	        head = head.next;
	        if (a != null) {
	            a = a.next;
	        }
	        if (b != null) {
	            b = b.next;
	        }
	    }
	    return dummy.next;
	    
	}
}