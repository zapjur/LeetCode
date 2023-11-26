class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int l = 0;
        int r = 0;
        Deque<Integer> q = new ArrayDeque<>();

        while(r < nums.length){
            while(!q.isEmpty() && nums[r] > nums[q.peekLast()]){
                q.pollLast();
            }
            q.offerLast(r);

            if(l > q.peekFirst()){
                q.pollFirst();
            }
            if(r + 1 >= k){
                res.add(nums[q.peekFirst()]);
                l++;
            }
            r++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
}
}