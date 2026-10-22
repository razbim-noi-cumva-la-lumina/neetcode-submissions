/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(final Node originalHead) {
        final Map<Node, Node> m = new HashMap<>();
        
        final Node fakeHead = new Node(-1);
        Node prev = fakeHead, head = originalHead;
        while (head != null) {
            final Node curr = new Node(head.val);
            m.put(head, curr);

            prev.next = curr;
            prev = curr;
            head = head.next;
        }

        head = originalHead;
        while (head != null) {
            if (head.random != null) {
                final Node curr = m.get(head);
                curr.random = m.get(head.random);
            }

            head = head.next;
        }

        return fakeHead.next;
    }
}
