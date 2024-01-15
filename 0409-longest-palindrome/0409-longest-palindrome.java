class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int odd = 0;
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);

            if(map.get(c) % 2 == 1){
                odd++;
            }
            else odd--;
        }
        if(odd > 1) return s.length() - odd + 1;
        return s.length();
    }
}