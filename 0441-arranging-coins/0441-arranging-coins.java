class Solution {
    public int arrangeCoins(int n) {
        int rows = 0;
        if(n == 1) return 1;
        for(int i = 1; i <= n; i++){
            rows++;
            n -= i;
        }
        return rows;
    }
}