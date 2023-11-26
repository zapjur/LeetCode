class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();

        for(char c : s.toCharArray()){
            count.put(c, count.getOrDefault(c,0) + 1);
        }
        for(char c: t.toCharArray()){
            count.put(c, count.getOrDefault(c,0) - 1);
        }

        for(int x : count.values()){
            if(x != 0) return false;
        }
        return true;
    }
}