/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * Floyd's algorithm. Increment one pointer by one and the other by two.
 * If they are ever pointing to the same node, there is a cycle.
 * There are other ways to do it as well.
 * a) we can start to push all elements one-by-one to a hashset. For every new element, we compare it's existance in set,
 * if it is there, means that we have already visited that element, hence a cycle exists.
 * b) Use 'visited' flag for each node we visit and check if we reached a visited node again. This approach will require a 
 * custom linked list development.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        
        while(fastPointer != null && fastPointer.next != null) {
            if(fastPointer == slowPointer) return true;
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return false;
    }
}
