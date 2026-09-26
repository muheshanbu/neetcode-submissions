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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;               //totally broke the even mid finding

        //Finding middle element
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reversing from middle
        ListNode mid = slow.next;
        slow.next = null;                       //cutting the link btw the 2 sides
        ListNode prev = null;
        while(mid != null){
            ListNode next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }

        //mid is at last now, all need to do i join the two halves
        ListNode first = head; //the first half, not mixed4
        //ListNode prev is the current head of the reversed half
        while(prev != null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = prev.next;

            first.next = prev;
            prev.next = tmp1;

            first = tmp1;
            prev = tmp2;
        }
    }
}