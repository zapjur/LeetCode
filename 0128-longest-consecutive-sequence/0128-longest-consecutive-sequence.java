class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
       HashSet<Integer> set = new HashSet<>();
       for(int num:nums) set.add(num);
       int longest =1;
       for(int num: nums ){

           if(!set.contains(num-1)){ 
                int currLongest =1;
                while(set.contains(num + 1)){
                    num++;
                    currLongest++;
                }
                longest = Math.max(longest, currLongest);
                
           }

       }
       return longest;
    }
}