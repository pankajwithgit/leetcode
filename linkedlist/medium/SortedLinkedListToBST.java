/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Finding out size of linkedlist is better (memory wise) than having two pointers (slow and fast) to reach the middle
// of the linkedlist and repeating this with each recursive round.
// Time: O(n) space O(logn)
class Solution {
    private ListNode head;
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        
        this.head = head;
        
        // Find the size of the linked list first.
        int size = findSize(head);
        
        // convert to BST now.
        return convertToBST(0, size - 1);
    }
    
    private TreeNode convertToBST(int start, int end) {
        if(start > end) return null;
        
        int mid = (start + end) / 2;
        
        // process the left tree first.
        TreeNode left = convertToBST(start, mid - 1);
        
        // Once left half is traversed, process the current node
        TreeNode node = new TreeNode(this.head.val);
        node.left = left;
        
        // Advance the head
        this.head = this.head.next;
        
        TreeNode right = convertToBST(mid + 1, end);
        node.right = right;
        
        return node;
    }
    
    private int findSize(ListNode head) {
        int size = 0;
        ListNode p = head;
        while(p != null) {
            size++;
            p = p.next;
        }
        return size;
    }
}
