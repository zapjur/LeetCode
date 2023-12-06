class Solution {
    public int totalMoney(int n) {
        int res = 0;
        int m = 1;

        while(n > 0){
            for(int day = 0; day < Math.min(n,7); day++){
                res += m + day;
            }
            n -= 7;
            m++;
        }
        return res;
    }
}