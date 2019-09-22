/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = new ListNode(0);
        ListNode pointer = root;
        while(true) {
            boolean isBreak = true;
            int min = Integer.MAX_VALUE;
            int indexForMin = 0;
            for(int i = 0; i < lists.length; i++) {
                if(lists[i] != null) {
                    if(lists[i].val < min) {
                        min = lists[i].val;
                        indexForMin = i;
                    }
                    isBreak = false;
                }
            }
            // check boundary condition and exit if done.
            if(isBreak) {
                break;
            }
            ListNode node = new ListNode(min);
            pointer.next = node;
            pointer = pointer.next;
            lists[indexForMin] = lists[indexForMin].next;
        }
        pointer.next = null;
        return root.next;
    }
}
