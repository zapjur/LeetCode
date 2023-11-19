class Solution {
    public double myPow(double x, int n) {
        if(n == 0 || x == 1) return 1;
        if(n == 1) return x;
        if(x == -1){
            if(n % 2 == 0) return 1;
            else return -1;
        }

        if(n < 0) return 1/(x * myPow(x, -(n+1)));

        if(n % 2 == 0) return myPow(x*x, n/2);

        return x * myPow(x * x, n / 2);
    }
}