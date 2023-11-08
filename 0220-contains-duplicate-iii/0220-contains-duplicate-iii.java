class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();

        for(int i = 0; i < nums.length; i++){

            Long num = new Long(nums[i]);
            Long floor = set.floor(num);
            Long ceil = set.ceiling(num);

            if(floor != null && Math.abs(floor - num) <= valueDiff) return true;

            if(ceil != null && Math.abs(ceil - num) <= valueDiff) return true;

            set.add(num);

            if(set.size() > indexDiff) set.remove(1L * nums[i - indexDiff]);
        }
        return false;
    }
}