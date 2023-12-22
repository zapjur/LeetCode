class Solution {
    public int maxScore(String s) {
        int max = 0;
        int zeros = 0;
        int ones = (int) s.chars().filter(ch -> ch == '1').count();

        for(int i = 0; i < s.length()-1; i++){
            zeros += s.charAt(i) == '0' ? 1 : 0;
            ones -= s.charAt(i) == '1' ? 1 : 0;

            max = Math.max(max, zeros + ones);
        }
        return max;
    }
}