class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();

    if(nums.length < 3) return ans;
    if(nums[0] > 0) return ans;

    HashMap<Integer, Integer> hashMap = new HashMap<>();

    for(int i = 0; i < nums.length; i++) hashMap.put(nums[i], i);

    for(int i = 0; i < nums.length - 2; i++){
        if(nums[i] > 0) break;

        for(int j = i + 1; j < nums.length - 1; j++){
            int required = -1*(nums[i] + nums[j]);
            if(hashMap.containsKey(required) && hashMap.get(required) > j){
                ans.add(Arrays.asList(nums[i], nums[j], required));
            }

            j = hashMap.get(nums[j]);
        }

        i = hashMap.get(nums[i]);
    }

        return ans;

    }
}