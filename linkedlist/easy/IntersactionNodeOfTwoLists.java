/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * Assuming the sizes of lists are different, find out their sizes first. Find the difference say x in sizes. Bypass the first 
 * x elements from longer list to make it equal in size to other list. Now, we can start comparing elements at same index from
 * both lists and return the node where value is same. Return null if no intersaction.
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);
        
        ListNode headANew = headA;
        ListNode headBNew = headB;
        
        if(sizeA > sizeB){
            headANew = chopOff(headA, sizeA - sizeB);
        }
        if(sizeB > sizeA){
            headBNew = chopOff(headB, sizeB - sizeA);
        }
        
        // Now Compare equal size lists.
        while(headANew != null && headBNew != null) {
            if(headANew.val == headBNew.val){
                return headANew;
            }
            headANew = headANew.next;
            headBNew = headBNew.next;
        }
        return null;
    }
    
    private int getSize(ListNode head) {
        int size = 0;
        ListNode pointer = head;
        
        while(pointer != null){
            size++;
            pointer = pointer.next;
        }
        return size;
    }
    
    private ListNode chopOff(ListNode head, int nodes) {
        ListNode target = head;
        for(int i = 0; i < nodes; i++) {
            target = target.next;
        }
        return target;
    }
}
