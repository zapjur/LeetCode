class Solution {
    public int countPalindromicSubsequence(String s) {
        int res = 0;
        Set<Character> unique = new HashSet<>();

        for(char c : s.toCharArray())
            unique.add(c);

        for(char c : unique){
            int start = s.indexOf(c);
            int last = s.lastIndexOf(c);

            if(start < last){
                Set<Character> set = new HashSet<>();
                for(int i = start + 1; i < last; i++){
                    set.add(s.charAt(i));
                }
                res += set.size();
            }
        }

        return res;
    }
}