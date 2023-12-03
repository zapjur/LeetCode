class Solution {
    public int helper(int[] from, int[] to) {
        int xDiff = Math.abs(from[0] - to[0]);
        int yDiff = Math.abs(from[1] - to[1]);
        
        return Math.max(xDiff, yDiff);
    }
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
    
        for (int i = 1; i < points.length; i++) {
            time += helper(points[i - 1], points[i]);
        }
        
        return time;
    }
}