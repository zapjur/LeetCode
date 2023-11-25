class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
         
        int n = nums.length;
        int[] res = new int[n];
        int[] pref = new int[n];
        int[] suf = new int[n];

        pref[0] = nums[0];
        suf[n-1] = nums[n-1];

        for(int i = 1; i< n; i++){
            pref[i] = pref[i-1] + nums[i];
            suf[n-i-1] = suf[n-i] + nums[n-i-1];
        }
        for(int i = 0; i < n; i++){
            res[i] = ((nums[i] * i) - pref[i]) + (suf[i] - (nums[i]) * (n-i-1));
        }

        return res;

    }
}