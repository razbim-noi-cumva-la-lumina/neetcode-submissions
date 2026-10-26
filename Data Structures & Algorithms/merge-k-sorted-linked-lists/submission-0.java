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
    public ListNode mergeKLists(final ListNode[] lists) {
        final Queue<ListNode> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.val, b.val);
        });
        for (final ListNode n : lists) if (n != null) pq.add(n);

        final ListNode fakeHead = new ListNode();
        ListNode curr = fakeHead;
        while (!pq.isEmpty()) {
            final ListNode min = pq.remove();
            final ListNode next = min.next;
            min.next = null;

            curr.next = min;
            curr = min;
            if (next != null) pq.add(next);
        }

        return fakeHead.next;
    }
}
