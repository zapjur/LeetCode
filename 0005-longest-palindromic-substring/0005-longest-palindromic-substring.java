class Solution {
    int maxLength = 0;
    int l = 0;
    public String longestPalindrome(String s) {

        char[] input = s.toCharArray();
        if(s.length() < 2){
            return s;
        }

        for(int i = 0; i < input.length; i++){
            expandPalindrome(input, i, i);
            expandPalindrome(input, i, i+1);
        }
        return s.substring(l, l+maxLength);

    }

    public void expandPalindrome(char[] s, int j, int k){
        while(j >= 0 && k < s.length && s[j] == s[k]){
            j--;
            k++;
        }

        if(maxLength < k - j- 1){
            maxLength = k - j -1;
            l = j+1;
        }
    }
}