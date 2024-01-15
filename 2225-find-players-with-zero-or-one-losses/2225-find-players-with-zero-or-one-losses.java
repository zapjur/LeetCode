class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
         for(int i = 0; i < matches.length; i++){
             map.put(matches[i][1], map.getOrDefault(matches[i][1], 0) + 1);
             map.putIfAbsent(matches[i][0], 0);
         }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
             if(entry.getValue() == 0) ans.get(0).add(entry.getKey());
             if(entry.getValue() == 1) ans.get(1).add(entry.getKey());
         }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
         return ans;
    }
}