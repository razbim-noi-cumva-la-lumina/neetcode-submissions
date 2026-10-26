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
    public ListNode reverseKGroup(ListNode head, final int k) {
        final ListNode fakeHead = new ListNode();
        ListNode curr = fakeHead;

        while (true) {
            ListNode fastPrev = null, fast = head;
            int i = 0;
            for (; i < k && fast != null; ++i) {
                fastPrev = fast;
                fast = fast.next;
            }

            if (i != k) {
                curr.next = head;
                break;
            }
            
            fastPrev.next = null;
            final ListNode headBak = head;
            curr.next = reverse(head);
            curr = headBak;
            // while (curr.next != null) curr = curr.next;
            head = fast;
        }

        return fakeHead.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            final ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
