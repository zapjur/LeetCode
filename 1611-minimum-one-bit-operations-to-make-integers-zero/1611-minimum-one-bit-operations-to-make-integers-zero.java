class Solution {
    public int minimumOneBitOperations(int n) {
        int res = 0, f = 0;

        for(int i = 31; i >= 0; i--){
            if(((n >> i) & 1) == 1){
                if(f == 0){
                    res += ((1 << (i+1))) - 1;
                    f = 1;
                }
                else{
                    res -= ((1 << (i+1)) - 1);
                    f = 0;
                }
            }
        }
        return res;
    }
    
}