class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        List<Integer> list = new ArrayList<>();
        for(int num : piles){
            list.add(num);
        }
        int sum = 0;
        while(!list.isEmpty()){
            list.remove(list.size()-1);
            sum += list.get(list.size()-1);
            list.remove(list.size()-1);
            list.remove(0);
        }
        return sum;
    }
}