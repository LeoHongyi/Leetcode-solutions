package algorithms.hashTable;

public class TopKFrequentWords {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/67
 * Method: 1. Map combo string with frequency,
 *  2. use minHeap size k to pick the top k most frequent words
 *  3. minHeap to String[]
 */
    public String[] topKFrequent(String[] combo, int k) {
        // Write your solution here
        if (combo.length == 0) {
            return new String[0];
        }
        // 1. Map combo string with frequency.
        Map<String, Integer> freqMap = getFreqMap(combo);
        // 2. use minHeap size k to pick the top k most frequent words
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new MyComparator());
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        //3. minHeap to String[]
        return freqArray(minHeap);
    }
    private Map<String, Integer> getFreqMap(String[] combo) {
        Map<String, Integer> freqMap = new HashMap<>();
        // Notice: when possible, choose the most efficient way for
        // HashMap operations.
        for (String s : combo) {
            Integer freq = freqMap.get(s);
            if (freq == null) {
                freqMap.put(s, 1);
            } else {
                freqMap.put(s, freq + 1);
            }
        }
        return freqMap;
    }
    // Override the comparator for Map.Entry<>
    class MyComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
            return e1.getValue().compareTo(e2.getValue());
        }
    }
    private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
        String[] result = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
}
