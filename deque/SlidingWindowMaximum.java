/*
Using Deque: Time complexity O(n)

Use Deque – Double ended queue and store only the data which is necessary or useful. Will store the index of array element in deque to keep track of k elements.
Deque will always have the data for max k elements (window). Initially will create the deque with first k elements and then slide the window by one element at a time, means discard the data which falls outside the new window and all data which falls within the new window.
To create the window for first k elements –
Every new element going into window(deque), Remove all the smaller elements indexes from the deque (since these elements are no longer required) and add the new element at the end.
Once the window is created for first k elements then for every new element going into window(deque) –
Remove the element index which falls outside the window.
And again remove all the smaller elements indexes from the deque (since these elements are no longer required) and add the new element index at the end.
Output from each window will be the first element in the deque (since deque is constructed in descending order as per the steps above.
Time Complexity: O(n), Space Complexity: O(k)
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        //Step 1: handle first k elements in sliding window
        for (int i = 0; i <k ; i++) {
            //remove all the elements which are smaller than the current elements
            while(deque.isEmpty()==false && nums[deque.peekLast()]<=nums[i])
                deque.removeLast();
            //add new element at the end
            deque.addLast(i);
        }

        //Step 2: handle rest of the element, one at a time nums[k] to nums[n-1]
        for (int i = k; i <nums.length ; i++) {

            //before we do anything, print the first element in deque
            //since its a maximum among previous k elements
            System.out.print(nums[deque.peekFirst()] + " ");
            res[index++] = nums[deque.peekFirst()];

            //Now remove the elements which are out for next window (next k elements)
            while(deque.isEmpty()==false && deque.peekFirst()<=i-k)
                deque.removeFirst();

            //Add the next element in the window = index i
            //remove all the elements which are smaller than the next element = index i
            while(deque.isEmpty()==false && nums[deque.peekLast()]<=nums[i])
                deque.removeLast();
            //add new element at the end
            deque.addLast(i);
        }
        //to print the last max element
        System.out.print(nums[deque.peekFirst()] + " ");
        res[index] = nums[deque.peekFirst()];
        return res;
    }
}
