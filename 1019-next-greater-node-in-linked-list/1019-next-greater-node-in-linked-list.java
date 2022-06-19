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
    public int[] nextLargerNodes(ListNode head) {
        int n = getSize(head);
        int[]arr = new int[n];
        Stack<pair>st = new Stack<>();
        
        int idx = 0;
        while(head != null){
            if(st.size() > 0 && st.peek().val < head.val){
                int v = head.val;
                while(st.size()!=0 && v > st.peek().val){
                    pair p = st.pop();
                    arr[p.idx] = v;
                }
            }
            st.add(new pair(head.val, idx++));
            head = head.next;
        }
        
        return arr;
    }
    public int getSize(ListNode head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }
    public class pair{
        int val;
        int idx;
        pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
}