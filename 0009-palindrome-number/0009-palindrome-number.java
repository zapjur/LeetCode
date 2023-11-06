class Solution {
    public boolean isPalindrome(int x) {

        if(x<0){
            return false;
        }

        String s  = String.valueOf(x);

        int size = s.length();

        for(int i = 0; i < size/2; i++){
            if(s.charAt(i) != s.charAt(size-i-1)){
                return false;
            }
        }
        return true;

        
    }
}