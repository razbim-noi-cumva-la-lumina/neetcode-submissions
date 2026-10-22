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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final ListNode fakeHead = new ListNode();
        ListNode prev = fakeHead;

        int carry = 0;
        while (l1 != null && l2 != null) {
            final int sum = l1.val + l2.val + carry;
            final ListNode curr = new ListNode(sum % 10);
            prev.next = curr;
            prev = curr;
            carry = sum / 10;

            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            final int sum = l1.val + carry;
            final ListNode curr = new ListNode(sum % 10);
            prev.next = curr;
            prev = curr;
            carry = sum / 10;

            l1 = l1.next;
        }
        while (l2 != null) {
            final int sum = l2.val + carry;
            final ListNode curr = new ListNode(sum % 10);
            prev.next = curr;
            prev = curr;
            carry = sum / 10;

            l2 = l2.next;
        }

        if (carry != 0) {
            final ListNode curr = new ListNode(carry);
            prev.next = curr;
        }

        return fakeHead.next;
    }
}
