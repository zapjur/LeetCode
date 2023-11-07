class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k == 0) return false;

        HashSet<Integer> set = new HashSet<Integer>();
        int j = 0;

        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i])) return true;

            if(set.size() >= k+1) set.remove(nums[j++]);
        }

        return false;
    }
}