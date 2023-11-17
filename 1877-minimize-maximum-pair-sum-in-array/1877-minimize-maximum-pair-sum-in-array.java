class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int maxSum = Integer.MIN_VALUE;

        int l = 0, r = nums.length - 1;

        while(l < r){
            int currSum = nums[l] + nums[r];

            maxSum = maxSum > currSum ? maxSum : currSum;

            l++;
            r--;
        }

        return maxSum;
    }
}