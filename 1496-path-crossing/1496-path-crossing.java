class Solution {
    public boolean isPathCrossing(String path) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        visited.add(new Pair(0, 0));

        Map<Character, Pair<Integer, Integer>> moves = new HashMap<>();
        moves.put('N', new Pair(0, 1));
        moves.put('S', new Pair(0, -1));
        moves.put('W', new Pair(-1, 0));
        moves.put('E', new Pair(1, 0));

        int x = 0;
        int y = 0;

        for(Character c : path.toCharArray()){
        
            x += moves.get(c).getKey();
            y += moves.get(c).getValue();

            Pair<Integer, Integer> pair = new Pair(x, y);

            if(visited.contains(pair)) return true;
            visited.add(pair);
        }
        return false;
    }
}