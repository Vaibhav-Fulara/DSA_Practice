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
    public ListNode insertionSortList(ListNode head) {
        ListNode sort = head;
        while(sort != null && sort.next != null){
            ListNode iter = sort.next;
            if(iter.val < sort.val){
                sort.next = iter.next;
                if (iter.val < head.val) {
                    iter.next = head;
                    head = iter;
                } else {
                    ListNode temp = head;
                    while(true){
                        if(temp.next.val > iter.val){
                            iter.next = temp.next;
                            temp.next = iter;
                            break;
                        }
                        temp = temp.next;
                    }
                }
            } else {
                sort = sort.next;
            }
        }
        return head;
    }
}