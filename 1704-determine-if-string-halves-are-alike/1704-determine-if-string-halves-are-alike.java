class Solution {
    public boolean halvesAreAlike(String s) {
        s=s.toLowerCase();
        int size = s.length();
        String a = s.substring(0, size/2);
        String b = s.substring(size/2);
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int counta = 0, countb = 0;
        for(int i = 0; i < a.length(); i++){
            if(vowels.contains(a.charAt(i))) counta++;
            if(vowels.contains(b.charAt(i))) countb++;
        
        }

        return counta==countb;
    }
}