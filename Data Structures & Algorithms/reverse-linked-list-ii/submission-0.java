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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode fakeHead = new ListNode(0, head);

        ListNode leftPrev = fakeHead;
        for (int i = 1; i < left; ++i) {
            leftPrev = head;
            head = head.next;
        }

        final ListNode leftHead = head;
        for (int i = left; i <= right; ++i) head = head.next;
        final ListNode rightNext = head;

        ListNode curr = leftPrev.next = reverseToStop(leftHead, head);
        while (curr.next != null) curr = curr.next;
        curr.next = rightNext;

        return fakeHead.next;
    }

    private ListNode reverseToStop(ListNode head, ListNode stop) {
        ListNode prev = null;
        while (head != null && head != stop) {
            final ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}