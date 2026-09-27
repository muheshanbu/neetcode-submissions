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
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        //since sum could start from either l1 or l2 and cant just use l1 since i would be needing a pointer before either of these two
        //run over to null and i cant add the final carry without a pointer that stays back to where - before null is reached
        ListNode current = new ListNode();
        ListNode head = current;
        int carryOver = 0;

        while(c1 != null && c2 != null){
            int sum = c1.val + c2.val + carryOver;

            carryOver = 0;                 //resetting carryover back to 0, since it done its job for this pair

            if(sum >= 10){
                //carry over logic
                carryOver = 1;
            }

            ListNode temp = new ListNode(sum%10);    //putting the sum back into a new node

            current.next = temp;
            current = temp;

            //Moving onto the next pair
            c1 = c1.next;
            c2 = c2.next;

        }
        
        //only 1 list could remain out of the 2
        ListNode remaining = (c1 != null) ? c1 : c2;
        while(remaining != null){
            int sum = remaining.val + carryOver;
            carryOver = 0;
            if(sum >= 10){
                carryOver = 1;
            }
            ListNode temp = new ListNode(sum%10);
            
            current.next = temp;
            current = temp;
            
            //moving the forward pointer
            remaining = remaining.next;
        }

        //if the carry over is still present, create a new node and add to it, like in 9 + 9 => 18
        if(carryOver != 0){
            ListNode newNode = new ListNode(carryOver);
            newNode.next = null;
            current.next = newNode;
        }
        return head.next;
    }
}
