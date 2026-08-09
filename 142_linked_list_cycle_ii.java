/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {

    public ListNode detectCycle(ListNode head) {

        // Step 1: Find whether a cycle exists
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {

                // Step 2: Find the starting node of the cycle
                ListNode start = head;

                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }

                return start;
            }
        }

        // No cycle
        return null;
    }
}