class Solution {
    public int divisorSubstrings(int num, int k) {
        int res = 0;
        String numS = String.valueOf(num);
        for(int i = 0; i+k <= numS.length(); i++){
            int curr = Integer.parseInt(numS.substring(i, i+k));
            if(curr != 0 && num%curr == 0){
                res++;
            }
        }
        return res;
    }
}