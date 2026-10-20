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
    public void reorderList(final ListNode head) {
        ListNode slowPrev = null, slow = head, fast = head;
        while (fast != null) {
            slowPrev = slow;
            slow = nextSafe(slow);
            fast = nextSafe(nextSafe(fast));
        }

        slowPrev.next = null;
        
        ListNode a = head;
        ListNode b = reverse(slow);
        boolean tick = true;

        while (a != null && b != null) {
            if (tick) {
                final ListNode aNext = a.next;
                a.next = b;
                a = aNext;
            } else {
                final ListNode bNext = b.next;
                b.next = a;
                b = bNext;
            }

            tick = !tick;
        }
    }

    private ListNode nextSafe(final ListNode n) {
        if (n == null) return null;
        return n.next;
    }

    private ListNode reverse(final ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            final ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
