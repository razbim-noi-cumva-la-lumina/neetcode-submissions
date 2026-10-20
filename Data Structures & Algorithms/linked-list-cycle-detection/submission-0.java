/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(final ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head;
        do {
            slow = nextSafe(slow);
            fast = nextSafe(nextSafe(fast));
            if (slow == fast && slow != null && fast != null) return true;
        } while (slow != fast && slow != null && fast != null);
        return false;
    }

    private ListNode nextSafe(final ListNode n) {
        if (n == null) return null;
        return n.next;
    }
}
