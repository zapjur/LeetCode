class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();

        for(int num : arr){
            nums.add(num);
        }

        int left = 0, right = nums.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums.get(mid) < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int l = left-1, r = right;

        while(res.size() < k){
            if(l < 0){
                res.add(nums.get(r++));
                continue;
            }
            if(r >= nums.size()){
                res.add(nums.get(l--));
                continue;
            }
            if(Math.abs(nums.get(l) - x) <= Math.abs(nums.get(r) - x)){
                res.add(nums.get(l--));
            }
            else{
                res.add(nums.get(r++));
            }
        }
        Collections.sort(res);
        return res;

    }
}