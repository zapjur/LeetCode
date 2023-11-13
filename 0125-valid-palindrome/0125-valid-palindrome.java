class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return false;

        int l = 0;
        int r = s.length() - 1;

        while(l <= r){
            char currL = s.charAt(l);
            char currR = s.charAt(r);

            if(!Character.isLetterOrDigit(currL)) l++;
            else if(!Character.isLetterOrDigit(currR)) r--;
            else{
                if(Character.toLowerCase(currL) != Character.toLowerCase(currR)) return false;
                l++;
                r--;
            }
            
        }

        return true;
    }
}