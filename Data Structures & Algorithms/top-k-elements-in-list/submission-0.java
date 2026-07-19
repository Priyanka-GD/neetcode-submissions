class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> 
        map.get(a) - map.get(b));

        for(int key : map.keySet()){
            pq.add(key);
        }

        while(!pq.isEmpty() && pq.size() > k){
            pq.poll();
        }

        int idx = 0;
        int result[] = new int[k];
        while(!pq.isEmpty() && idx < k){
            result[idx++] = pq.poll();
        }
        return result;
    }
}
