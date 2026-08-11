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

    public ListNode doubleIt(ListNode head) {

        // Step 1: Reverse the linked list
        head = reverse(head);

        // Step 2: Double each digit
        ListNode temp = head;
        int carry = 0;

        while (temp != null) {

            int value = temp.val * 2 + carry;

            temp.val = value % 10;
            carry = value / 10;

            temp = temp.next;
        }

        // Add remaining carry
        if (carry > 0) {
            temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new ListNode(carry);
        }

        // Step 3: Reverse again
        head = reverse(head);

        return head;
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}