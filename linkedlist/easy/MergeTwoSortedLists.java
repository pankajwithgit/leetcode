/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        // Base cases
        if(l1 == null && l2 == null) {
            return null; 
        } else if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        }
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode result = new ListNode(-1);
        ListNode current = result;
        
        // Scan through both lists simultaneously 
        while(p1 != null && p2 != null) {
            int val;
            if(p1.val < p2.val) {
                val = p1.val;    
                p1 = p1.next;
            } else {
                val = p2.val;
                p2 = p2.next;
            }
            ListNode node = new ListNode(val);
            current.next = node;
            current = node;
        }
        
        // In case p1 has got more elements.
        if(p1 != null) {
            while(p1 != null) {
                ListNode node = new ListNode(p1.val);
                current.next = node;
                current = node;
                p1 = p1.next;
            }
        }
        
        // In case p2 has got more elements.
        if(p2 != null) {
            while(p2 != null) {
                ListNode node = new ListNode(p2.val);
                current.next = node;
                current = node;
                p2 = p2.next;
            }
        }
        
        return result.next;
    }
    
    private void printList(ListNode node) {
        StringBuffer str = new StringBuffer();
        
        ListNode p = node;
        while(p != null) {
            str.append(p.val + " ->");
            p = p.next;
        }
        System.out.println(str.toString());
    }
}
