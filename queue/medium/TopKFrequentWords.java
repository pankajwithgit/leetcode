class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> results = new ArrayList<>();
        Map<String, Integer> freqMap = new HashMap<>();
        
        if(words == null || words.length == 0) return results;
        
        for(int i = 0; i < words.length; i++) {
            freqMap.put(words[i], freqMap.getOrDefault(words[i], 0) + 1);
        }
        
        // Build a min heap having size as k, pass all words, poll k element towards the end and reverse them.
        Queue<String> q = new PriorityQueue<>((w1, w2) -> freqMap.get(w1).equals(freqMap.get(w2)) ? 
                                             w2.compareTo(w1) : freqMap.get(w1) - freqMap.get(w2));
        
        for(String key : freqMap.keySet()) {
            q.offer(key);
            
            if(q.size() > k) {
                q.poll();
            }
        }
        
        while(!q.isEmpty()) {
            results.add(q.poll());
        }
        
        Collections.reverse(results);
        
        return results;
    }
}
