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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer>hs = new HashSet<>();
        for(int num:nums) hs.add(num);
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            if(hs.contains(temp.val)){
                count++;
                while(temp != null && hs.contains(temp.val)) {
                    hs.remove(temp.val);
                    temp = temp.next;
                }
            } else {
                temp = temp.next;
            }
        }
        return count;
    }
}