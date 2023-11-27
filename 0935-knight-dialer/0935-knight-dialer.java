class Solution {
    public int knightDialer(int n) {
        int mod = (int)Math.pow(10,9)+7;
        long[] resPos = new long[10];
        Arrays.fill(resPos, 1);

        for(int i = 2; i <= n; i++){
            long[] currPos = new long[10];

            currPos[0] = (resPos[6] + resPos[4]) % mod;
            currPos[1] = (resPos[6] + resPos[8]) % mod;
            currPos[2] = (resPos[7] + resPos[9]) % mod;
            currPos[3] = (resPos[4] + resPos[8]) % mod;
            currPos[4] = (resPos[0] + resPos[3] + resPos[9]) % mod;
            currPos[5] = 0;
            currPos[6] = (resPos[0] + resPos[1] + resPos[7]) % mod;
            currPos[7] = (resPos[2] + resPos[6]) % mod;
            currPos[8] = (resPos[1] + resPos[3]) % mod;
            currPos[9] = (resPos[2] + resPos[4]) % mod;

            resPos = currPos;
        }

        long res = 0;
        for(long i : resPos){
            res = (res + i)%mod;
        }
        return (int) res;
    }
}