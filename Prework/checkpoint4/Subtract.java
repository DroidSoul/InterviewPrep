public class Solution {
    public ListNode subtract(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode slow = A;
        ListNode fast = A;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverseList(slow.next);
        ListNode origNewHead = newHead;
        slow.next = null;
        ListNode head = A;
        while (newHead != null) {
            head.val = newHead.val - head.val;
            head = head.next;
            newHead = newHead.next;
        }
        slow.next = reverseList(origNewHead);
        return A;
        
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}