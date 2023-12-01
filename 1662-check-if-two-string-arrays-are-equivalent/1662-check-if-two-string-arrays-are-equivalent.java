class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for(String word : word1){
            s1.append(word);
        }
        for(String word : word2){
            s2.append(word);
        }

        String st1 = s1.toString();
        String st2 = s2.toString();

        return st1.equals(st2);
    }
}