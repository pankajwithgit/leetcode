class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        PriorityQueue<String> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i <= searchWord.length(); i++) {
            String t = searchWord.substring(0, i);
            for (String product: products) {
                if (product.startsWith(t)) {
                    heap.offer(product);
                }
                if (heap.size() > 3) {
                    heap.poll();
                }
            }
            
            LinkedList<String> temp = new LinkedList<>();
            while (!heap.isEmpty()) {
                temp.addFirst(heap.poll());
            }
            result.add(temp);
        }
        return result;
    }
}
