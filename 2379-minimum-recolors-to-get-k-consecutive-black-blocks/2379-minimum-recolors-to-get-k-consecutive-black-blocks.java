class Solution {
    public int minimumRecolors(String blocks, int k) {
        int min = Integer.MAX_VALUE;

        for(int i = k; i <= blocks.length(); i++){
            String temp = blocks.substring(i-k, i);
            min = Math.min(min, count(temp));
        }

        return min;
    }
    
    private int count(String s){
      int res = 0;
      for(int i = 0; i < s.length(); i++){
        if(s.charAt(i) == 'W') res++;
      }
      return res;
    }
}