class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= nums.length; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}