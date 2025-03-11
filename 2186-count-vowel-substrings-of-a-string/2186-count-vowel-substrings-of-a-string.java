class Solution {
    public int countVowelSubstrings(String word) {
        int n = word.length();
        int res = 0;
        
        Set<Character> vowels = new HashSet<>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');

        for (int i = 0; i < n; i++) {
            if (!vowels.contains(word.charAt(i))) continue;
            
            Set<Character> seenVowels = new HashSet<>();
            
            for (int j = i; j < n; j++) {
                char ch = word.charAt(j);
                
                if (!vowels.contains(ch)) break;
                
                seenVowels.add(ch);
                
                if (seenVowels.size() == 5) {
                    res++;
                }
            }
        }
        return res;
    }
}
