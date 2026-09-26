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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
                return null;
        ListNode current = head;
        int size = 0;
        while(current != null){
            size++;
            current = current.next;
        }
        

        int index = 1;
        ListNode second = head;

        if(n == size){
            return head.next;
        }

        while(second != null){
            if(index == size - n) {
                //so now i arrived at the element before the element to remove
                //since from front the element to remove is size - n + 1
                ListNode toBeDel = second.next;
                second.next = toBeDel.next;
            }
            index++;
            second = second.next;
        }
        return head;
    }
}
