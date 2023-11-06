class Solution {
    public int myAtoi(String s) {
        int i = 0;
        boolean isNeg = false;

        while(i < s.length() && s.charAt(i) == ' ')
            i++;

        if(i == s.length()) return 0;

        if(s.charAt(i) == '+') i++;
        else if(s.charAt(i) == '-'){
            i++;
            isNeg = true;
        }

        long ans = 0;

        for(; i < s.length(); i++){
            if(s.charAt(i) < '0' || s.charAt(i) > '9') break;

            ans = ans*10 + s.charAt(i) - '0';

            if(!isNeg && ans > (Math.pow(2, 31)-1)){
                ans = (long)(Math.pow(2, 31)-1);
                break;
            }
            else if(isNeg && ans > Math.pow(2, 31)){
                ans = (long)Math.pow(2, 31);
                break;
            }
        }

        
        if(isNeg) return (int) (-1*ans);

        return(int) ans;

    }
}