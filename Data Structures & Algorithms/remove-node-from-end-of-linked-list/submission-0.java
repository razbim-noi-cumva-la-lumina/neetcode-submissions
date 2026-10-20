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
    public ListNode removeNthFromEnd(ListNode head, final int n) {
        head = reverse(head);
        final ListNode fakeHead = new ListNode(0, head);
        ListNode curr = fakeHead;
        for (int i = 0; i < n - 1; ++i) {
            curr = curr.next;
        }

        final ListNode next = curr.next;
        if (next != null) {
            curr.next = next.next;
            next.next = null;
        }

        return reverse(fakeHead.next);
    }

    private ListNode reverse(ListNode curr) {
        ListNode prev = null;
        while (curr != null) {
            final ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
