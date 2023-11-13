class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        String allVowels = "aeiouAEIOU";
        for(char c : s.toCharArray()){
            if(allVowels.indexOf(c) != -1){
                vowels.add(c);
            }
        }

        Collections.sort(vowels, Collections.reverseOrder());

        System.out.println(vowels);

        StringBuilder res = new StringBuilder();

        for(char c : s.toCharArray()){
            if(allVowels.indexOf(c) != -1){
                res.append(vowels.get(vowels.size() - 1));
                vowels.remove(vowels.size()-1);
            }else{
                res.append(c);
            }
        }
        return res.toString();

    }
}