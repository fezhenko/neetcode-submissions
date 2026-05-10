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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists == null) {
            return null;
        }
        int j = 1;
        while (j < lists.length) {
            for (int i = 0; i + j < lists.length; i = i + j * 2) {
                lists[i] = mergeSortedNodes(lists[i], lists[i + j]);
            }
            j *= 2;
        }
        return lists[0];
    }

    private ListNode mergeSortedNodes(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.val < right.val) {
            left.next = mergeSortedNodes(left.next, right);
            return left;
        } else {
            right.next = mergeSortedNodes(left, right.next);
            return right;
        }
    }
}
