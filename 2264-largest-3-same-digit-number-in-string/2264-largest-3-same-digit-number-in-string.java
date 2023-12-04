class Solution {
    public String largestGoodInteger(String num) {
        int res = -1;
        for(int i = 2; i < num.length(); i++){
            if(num.charAt(i-2) == num.charAt(i-1) && num.charAt(i-1) == num.charAt(i)){
                res = Math.max(res, num.charAt(i) - '0');
            }
        }
        if(res == -1) return "";
        String temp = String.valueOf(res);
        String ans = temp + temp + temp;

        return ans;
    }
}