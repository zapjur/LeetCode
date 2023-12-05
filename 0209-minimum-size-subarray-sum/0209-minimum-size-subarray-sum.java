class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int currSum = 0;
        int ans = Integer.MAX_VALUE;
        while(r < nums.length){
            currSum += nums[r];
            while(currSum >= target){
                ans = Math.min(ans, r-l+1);
                currSum -= nums[l];
                l++;
            }
            r++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}