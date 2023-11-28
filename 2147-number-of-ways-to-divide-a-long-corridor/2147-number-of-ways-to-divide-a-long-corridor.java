class Solution {
    public int numberOfWays(String corridor) {
        int mod = (int)Math.pow(10, 9) + 7;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < corridor.length(); i++){
            if(corridor.charAt(i) == 'S') list.add(i);
        }

        if(list.size()%2 != 0 || list.size() == 0){
            return 0;
        }

        int prev = list.get(1);
        long res = 1;
        
        for(int i = 2; i < list.size(); i+=2){
            int length = list.get(i) - prev;
            res = (res*length) % mod;
            prev = list.get(i+1);
        }
        return (int) res;
    }
}