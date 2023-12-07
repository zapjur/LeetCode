class Solution {
    public String largestOddNumber(String num) {
        int l = 0;
        for(int r = num.length()-1; r >= 0; r--){
            if(num.charAt(l) == '0'){
                l++;
            }
            if(Character.getNumericValue(num.charAt(r)) % 2 != 0){
                return num.substring(l,r+1);
            }

        }
        return new String();
    }
}