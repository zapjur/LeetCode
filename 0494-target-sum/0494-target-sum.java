class Solution {
    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return res;
    }
    private void backtrack(int[] nums, int target, int currSum, int currIndex){
        if(currIndex == nums.length){
            if(currSum == target){
                res++;
                return;
            }
            else return;
        }

        backtrack(nums, target, currSum+nums[currIndex], currIndex+1);
        backtrack(nums, target, currSum-nums[currIndex], currIndex+1);

    }
}