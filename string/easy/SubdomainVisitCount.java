class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> results = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();
        
        if(cpdomains == null || cpdomains.length == 0) return results;
        
        for(String domain : cpdomains) {
            String[] tokens = domain.split(" ");
            int count = Integer.parseInt(tokens[0]);
            
            String domains = tokens[1];
            while(domains.indexOf('.') != -1) {
                countMap.put(domains, countMap.getOrDefault(domains,0) + count);
                domains = domains.substring(domains.indexOf('.') + 1);
            }
            countMap.put(domains, countMap.getOrDefault(domains,0) + count);
        }
        for(Map.Entry<String,Integer> entry : countMap.entrySet()) {
            results.add(entry.getValue() + " " + entry.getKey());
        }
        return results;
    }
}
