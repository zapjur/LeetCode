class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int s = nums.length;
        return (nums[s-1] * nums[s-2]) - (nums[0] * nums[1]);
    }
}