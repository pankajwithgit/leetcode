/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 Complexity for this solution is O(n) time and O(1) space.
 We will first reach head of second half of list, reverse it and compare with first half.
 
 There are other ways to do this problem easily but they may use additional space, suppose if we use stack to persist first
 half of list and the moment we reach the head of second half, we can pop elements from stack and compare with second half.
 
 Or we can reverse the complete linked list into a new list and compare both lists. But these solutions will comsume extra 
 time and space. 
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        ListNode firstHead = head;
        
        while(fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        
        // We know that fastPointer will always be on odd values i.e. 1,3,5,7...
        // Hence, if list has odd number of elements, we need to skip comparing 
        // exactly the middle element, so we will advance slowPointer by 1.
        // If list has even number of elements, fastpointer will be null at this time
        // and slowpointer will exactly be at the head of second half of list.
        // for eg. suppose there are 6 elements, when fast pointer will be at 7, 
        // slowPointer will be at 4th element, which is the head/beginning of second half
        if(fastPointer != null) {
            slowPointer = slowPointer.next;
        }
        //printList(slowPointer);
        ListNode secHead = reverseUsingIterativeMethod(slowPointer);
        //printList(secHead);
        // Now compare both sub lists.
        while(secHead != null && firstHead != null) {
            if(secHead.val != firstHead.val) return false;
            secHead = secHead.next;
            firstHead = firstHead.next;
        }
        return true;
    }
    
    public ListNode reverseUsingIterativeMethod(ListNode head) {
        ListNode prev = null;
        
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    
    public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
	    }
		System.out.println();
	}
}
