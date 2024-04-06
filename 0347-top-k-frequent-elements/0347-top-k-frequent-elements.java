class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        int i = 0;
        while(i < k) {
            res[i++] = pq.poll().getKey();
        }

        return res;
    }
}