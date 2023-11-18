class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        long l = 2, r = num;

        while(l < r){
            long mid = l + (r - l)/2;
            if((mid*mid) == num) return true;
            else if((mid*mid) > num) r = mid;
            else l = mid + 1;
        }
        return false;
    }
}