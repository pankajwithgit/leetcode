class Solution {
    public String frequencySort(String s) {
        // edge case
        if(s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        
        // Build freq map
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        
        // Sort by frequency
        Queue<Character> q = new PriorityQueue<>((c1, c2) -> 
                                                 freqMap.get(c2) - freqMap.get(c1));
        for(Character c : freqMap.keySet()) {
            q.offer(c);
        }
        
        // now, build output
        while(!q.isEmpty()) {
            Character c = q.poll();
            Integer freq = freqMap.get(c);
            while(freq > 0) {
                sb.append(c);
                freq--;
            }
        }
        return sb.toString();
    }
}
