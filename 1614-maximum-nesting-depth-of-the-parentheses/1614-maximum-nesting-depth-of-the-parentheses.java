class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int currMax = 0;
        for(char c : s.toCharArray()) {
            if(c == '('){
                currMax++;
                max = Math.max(max, currMax);
            }
            else if(c == ')'){
                currMax--;
            }
        }
        return max;
    }
}