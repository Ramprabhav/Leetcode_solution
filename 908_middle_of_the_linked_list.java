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
    public ListNode middleNode(ListNode head) {
        int s=0;
        ListNode temp=head;
        while(temp!=null){
            s++;
            temp=temp.next;
        }
        int m=s/2;
        temp=head;
        int i=0;
        while(i<m){
            temp=temp.next;
            i++;
        }
     return temp;
    }
}