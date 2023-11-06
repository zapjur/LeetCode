class Solution {
    public List<String> letterCombinations(String digits) {
        
        if(digits.isEmpty()) return Collections.emptyList();

        String[] phoneMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        backtrack("", digits, phoneMap, ans);
        return ans;
    }

    private void backtrack(String comb, String nextDigits, String[] phoneMap, List<String> ans){
        if (nextDigits.isEmpty()) ans.add(comb);
        else{
            String letters = phoneMap[nextDigits.charAt(0) - '2'];
            for(char letter : letters.toCharArray()){
                backtrack(comb + letter, nextDigits.substring(1), phoneMap, ans);
            }
        }
    }
}