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
    public int getDecimalValue(ListNode head) {
        int dec=0;
        ListNode temp=head;
        ListNode prev=null;
        ListNode next;
        while(temp!=null){
            next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        ListNode right=prev;
        ListNode righttemp=right;
        int p=0;
        while(righttemp!=null){
           dec=dec+righttemp.val*(int)Math.pow(2,p);
           p++;
           righttemp=righttemp.next;
        }
        return dec;
    }
}