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
    private Set<ListNode> set = new HashSet<>();

    public boolean hasCycle(ListNode head) {
        // brute force
        // Set<ListNode> set = new HashSet<>();
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        } else {
            if (set.contains(head.next)) {
                return true;
            } else {
                set.add(head);
            }
            return hasCycle(head.next);
        }
    }
}
