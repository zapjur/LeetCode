class Solution {
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int size = nums.length;
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[size-1]++; 
        }
        return sum;
    }
}