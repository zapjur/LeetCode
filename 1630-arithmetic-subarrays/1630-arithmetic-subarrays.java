class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0; i < l.length; i++){
            
            int left = l[i], right = r[i];
            int[] temp = new int[right - left + 1];
            for(int k = 0; k <= right - left; k++){
                temp[k] = nums[left+k];
            }
            Arrays.sort(temp);
            int diff = Math.abs(temp[0] - temp[1]);
            boolean flag = true;

            for(int j = 1; j < temp.length-1; j++){
                if(Math.abs(temp[j] - temp[j+1]) != diff){
                    ans.add(false);
                    flag = false;
                    break;
                }
            }

            if(flag) ans.add(true);
        }
        return ans;
    }
}