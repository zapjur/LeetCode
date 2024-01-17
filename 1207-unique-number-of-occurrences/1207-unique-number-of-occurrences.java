class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> occur = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(occur.contains(entry.getValue())) return false;
            occur.add(entry.getValue());
        }
        return true;
    }
}