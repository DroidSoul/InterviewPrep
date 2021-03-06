/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode mergeTwoLists(ListNode a, ListNode b) {
	    ListNode dummy = new ListNode(-1);
	    ListNode head = dummy;
	    while (a != null || b != null) {
	        if (a == null) {
	            head.next = b;
	            break;
	        }
	        else if (b == null) {
	            head.next = a;
	            break;
	        }
	        else {
	            if(a.val <= b.val) {
	                head.next = a;
	                a = a.next;
	            }
	            else {
	                head.next = b;
	                b = b.next;
	            }
	        }
	        head = head.next;
	    }
	    return dummy.next;
	}
}