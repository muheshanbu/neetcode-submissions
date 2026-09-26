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
            
            //if anyone is still pending, that has its linkage intact, so just need to connect
            //currentMain to  that
            currentMain.next = (currentList1 != null) ? currentList1 : currentList2;

            return dummyHead.next;
    }
}