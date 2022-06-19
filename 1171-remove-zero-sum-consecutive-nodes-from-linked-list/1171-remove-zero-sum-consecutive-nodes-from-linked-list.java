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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode temp = new ListNode(0), cur = temp;
        temp.next = head;
        int sum = 0;
        Map<Integer, ListNode> hm = new HashMap<>();
        while (cur != null) {
            sum += cur.val;
            if (hm.containsKey(sum)) {
                cur =  hm.get(sum).next;
                int sumFromParent = sum + cur.val;
                while (sumFromParent != sum) {
                    hm.remove(sumFromParent);
                    cur = cur.next;
                    sumFromParent += cur.val;
                }
                hm.get(sum).next = cur.next;
            }
            else hm.put(sum, cur);
            cur = cur.next;
        }
        return temp.next;
    }
}


    