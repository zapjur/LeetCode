class Solution {
    public int countNicePairs(int[] nums) {
        
        int res = 0;
        int mod = (int) Math.pow(10,9) + 7;
        Map<Integer, Integer> count = new HashMap<>();

        for(int n : nums){
            int rev = rev(n);
            int curr = count.getOrDefault(n - rev, 0);
            count.put(n - rev, curr+1);
            res = (res + curr) % mod;
        }

        return res;

    }
    private int rev(int num){
        int rev = 0;

        while(num > 0){
            int digit = num % 10;
            rev = rev * 10 + digit;
            num = num /10;
        }
        return rev;
    }
}