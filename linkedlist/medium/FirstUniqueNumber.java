/*
Complexity Analysis

Let K be the length of the initial array passed into the constructor.

Let N be the total number of items added onto the queue so far (including those from the constructor).

Time complexity :

constructor: O(K).

For each of the K numbers passed into the constructor, we're making a call to add(). As we will determine below, each call to add() has a cost of O(1). Therefore, for the K numbers added in the constructor, we get a total cost of K.O(1) = O(K).

add(): O(1).

Like before, we're performing a series of O(1) operations when add() is called. Additionally, we're also removing the number from the queue if it had been unique, but now no longer is. Seeing as the queue is implemented as a LinkedHashSet, the cost of this removal is O(1).

Therefore, we get an O(1) time complexity for add().

showFirstUnique(): O(1).

This time around, the implementation for showFirstUnique() is straightforward. It simply checks whether or not the queue contains any items, and if it does, it returns the first one (without removing it). This has a cost of O(1).

Space complexity : O(N).

Each number is stored up to once in the LinkedHashSet, and up to once in the HashMap. Therefore, we get an overall space complexity of O(N).
*/
class FirstUnique {
  
  private Set<Integer> setQueue = new LinkedHashSet<>();
  private Map<Integer, Boolean> isUnique = new HashMap<>();
  
  public FirstUnique(int[] nums) {
    for (int num : nums) {
      this.add(num);
    }
  }
    
  public int showFirstUnique() {
    // If the queue contains values, we need to get the first one from it.
    // We can do this by making an iterator, and getting its first item.
    if (!setQueue.isEmpty()) {
       return setQueue.iterator().next();
    }
    return -1;
  }
    
  public void add(int value) {
    // Case 1: This value is not yet in the data structure.
    // It should be ADDED.
    if (!isUnique.containsKey(value)) {
      isUnique.put(value, true);
      setQueue.add(value);
    // Case 2: This value has been seen once, so is now becoming
    // non-unique. It should be REMOVED.
    } else if (isUnique.get(value)) {
      isUnique.put(value, false);
      setQueue.remove(value);
    }
  }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
