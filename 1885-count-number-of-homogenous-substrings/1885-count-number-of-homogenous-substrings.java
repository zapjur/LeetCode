class Solution {
    public int countHomogenous(String s) {
        int res = 1;
        int mod = (int) Math.pow(10,9) + 7;
        int start = 0;

        for(int i = 1; i < s.length(); i++){
            res++;
            if(s.charAt(start) != s.charAt(i)){
                start = i;
            }
            else{
                int j = i - start;
                res = (res+j)%mod;
            }
        }

        return res%mod;
    }
}