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
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        int remainder = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1 != null || p2 != null) {
            int val1 = (p1 != null) ? p1.val : 0;
            int val2 = (p2 != null) ? p2.val : 0;
            int sum = val1 + val2;
            sum += remainder;
            if(sum < 10) {
                remainder = 0;
            } else {
                remainder = 1;
            }
            
            ListNode node = new ListNode(sum % 10);
            current.next = node;
            current = current.next;
            if(p1 != null) {
                p1 = p1.next;
            }
            if(p2 != null) {
                p2 = p2.next;
            }
        }
        if(remainder != 0) {
            current.next = new ListNode(remainder);
        }
        return dummyNode.next;
    }
}
