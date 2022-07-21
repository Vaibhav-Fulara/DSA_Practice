class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;
        
        while(left > 1) {
            previous = current;
            current = current.next;
            left--;
            right--;
        }
        
        ListNode connection = previous;
        ListNode tail = current;
        
        while(right > 0) {
            right --;
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        if(connection != null) {
            connection.next = previous;
        } else {
            head = previous;
        }
        
        tail.next = current;
        return head;
    }
}