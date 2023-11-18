class Solution {
    public int maxFrequency(int[] nums, int k) {
        int maxF = 0;
        long currSum = 0;

        Arrays.sort(nums);

        for(int left = 0, right = 0; right < nums.length; right++){

            currSum += nums[right];

            while(currSum + k < (long) nums[right] * (right - left + 1)){
                currSum -= nums[left];
                left++;
            }
            maxF = Math.max(maxF, right - left + 1);
        }

        return maxF;
    }
}