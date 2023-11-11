class Graph {

    private List<List<int[]>> adjList;

    public Graph(int n, int[][] edges) {
        adjList = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            addEdge(edge);
        }
    }
    
    public void addEdge(int[] edge) {
        int[] edgeArray = {edge[1], edge[2]};
        adjList.get(edge[0]).add(edgeArray);
    }
    
    public int shortestPath(int node1, int node2) {
        int n = adjList.size();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[node1] = 0;

        PriorityQueue<int[]> prioQ = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        prioQ.add(new int[]{0, node1});

        while(!prioQ.isEmpty()){
            int[] curr = prioQ.poll();
            int currNode = curr[1], currCost = curr[0];

            if(currCost > distances[currNode]) continue;

            if(currNode == node2) return currCost;

            for(int[] edge : adjList.get(currNode)){
                int neighbor = edge[0], edgeLen = edge[1];
                int newCost = edgeLen + distances[currNode];

                if(distances[neighbor] > newCost){
                    distances[neighbor] = newCost;
                    prioQ.add(new int[]{newCost, neighbor});
                }
            }
        }

        return ((distances[node2] == Integer.MAX_VALUE) ? -1 : distances[node2]);
    }

}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */