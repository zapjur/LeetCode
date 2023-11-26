class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();

        int i = 0, j = 0;
        int turn = 0;
        while(i < word1.length() && j < word2.length()){
            if(turn%2 == 0){
                ans.append(word1.charAt(i++));
            }
            else{
                ans.append(word2.charAt(j++));
            }
            turn++;
        }
        if(i < word1.length()){
            while(i < word1.length()){
                ans.append(word1.charAt(i++));
            }
        }
        else if(j < word2.length()){
            while(j < word2.length()){
                ans.append(word2.charAt(j++));
            }
        }

        return ans.toString();
    }
}