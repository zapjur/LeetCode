class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int k = processString(sArr);
        int p = processString(tArr);

        if (k!=p) return false;

        for (int i = 0; i < k; i++){
            if(sArr[i] != tArr[i]) return false;
        }

        return true;

        
    }

    private int processString(char[] arr){
        int k = 0;
        for(char c : arr){
            if(c != '#'){
                arr[k++] = c;
            }
            else if (k > 0){
                k --;
            }
        }
        return k;
    }
}