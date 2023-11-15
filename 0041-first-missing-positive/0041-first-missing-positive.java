class Solution {
    public int firstMissingPositive(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) heap.add(nums[i]);
        }

        int minMiss = 1;

        while(!heap.isEmpty()){
            int curr = heap.poll();

            if(minMiss == curr) minMiss++;
            else if(curr > minMiss) break;


        }

        return minMiss;
    }
}