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
     public ListNode addTwoNumbers(ListNode c1, ListNode c2) {
        //since sum could start from either l1 or l2 and cant just use l1 since i would be needing a pointer before either of these two
        //run over to null and i cant add the final carry without a pointer that stays back to where - before null is reached
        ListNode current = new ListNode();
        ListNode head = current;
        int carryOver = 0;

        //covers all three cases of either list is greater and final carry remaining too
        while(c1 != null || c2 != null || carryOver != 0){
            
            //the sum is c1 plus c2 and carry
            int sum = (c1 != null ? c1.val : 0) + (c2 != null ? c2.val : 0) + carryOver;
            
            carryOver = 0;                 //resetting carryover back to 0, since it done its job for this pair

            if(sum >= 10){
                //carry over logic
                carryOver = 1;
            }

            ListNode temp = new ListNode(sum%10);    //putting the sum back into a new node

            current.next = temp;
            current = temp;

            //Moving onto the next pair
            if(c1 != null)
                c1 = c1.next;
            if(c2 != null)
                c2 = c2.next;

        }
        
        return head.next;
    }
}
