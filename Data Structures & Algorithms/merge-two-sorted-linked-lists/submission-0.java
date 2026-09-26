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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
            ListNode currentMain = dummyHead;

            ListNode currentList1 = list1;
            ListNode currentList2 = list2;

            while(currentList1 != null && currentList2 != null){
                if(currentList2.val >= currentList1.val){
                    ListNode next1 = currentList1.next;
                    currentMain.next = currentList1;
                    currentMain = currentList1;
                    currentList1 = next1;
                }else {
                    ListNode next2 = currentList2.next;
                    currentMain.next = currentList2;
                    currentMain = currentList2;
                    currentList2 = next2;
                }
            }
            //2 is merged but 1 is still pending
            while(currentList1 != null){
                ListNode next1 = currentList1.next;
                currentMain.next = currentList1;
                currentMain = currentList1;
                currentList1 = next1;
            }

            //1 is merged but 2 is still pending
            while(currentList2 != null){
                ListNode next2 = currentList2.next;
                currentMain.next = currentList2;
                currentMain = currentList2;
                currentList2 = next2;
            }

            return dummyHead.next;
    }
}