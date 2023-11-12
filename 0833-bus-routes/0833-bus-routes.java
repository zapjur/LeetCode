class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < routes.length; i++){
            for(int stop : routes[i]){
                map.putIfAbsent(stop, new ArrayList<>());
                map.get(stop).add(i);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(source);
        int count = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                ArrayList<Integer> buses = map.get(queue.poll());
                for(int bus : buses){
                    if(visited.contains(bus)) continue;

                    visited.add(bus);
                    for(int stop:routes[bus]){
                        if(stop == target) return count+1;
                        queue.offer(stop);
                    }
                }
            }

            count++;
        }

        return -1;

    }
}