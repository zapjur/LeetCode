class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> list = new ArrayList<>();
        int g = -1;

        for(int i = 0; i < words.length; i++) {
            if(groups[i] != g) {
                g = groups[i];
                list.add(words[i]);
            }
        }
        return list;
    }
}