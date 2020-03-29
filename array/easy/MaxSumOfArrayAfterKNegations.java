class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        if(A == null) return 0;
        int len = A.length;
        
        if(K > len) throw new IllegalArgumentException();
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int sum = 0;
        
        for (int num : A) {
            minHeap.add(num);
            sum += num;
        }
        
        while (K != 0) {
            int num = minHeap.poll();
            sum -= num;
            sum += -num;
            
            minHeap.add(-num);
            
            K--;
        }
        
        return sum;
    }
}

