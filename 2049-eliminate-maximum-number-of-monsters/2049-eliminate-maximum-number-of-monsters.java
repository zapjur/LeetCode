class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] timeToCity = new double[n];

        for(int i = 0; i < n; i++){
            timeToCity[i] = (double)dist[i]/speed[i];
        }

        Arrays.sort(timeToCity);

        for(int i = 0; i < n; i++){
            if(timeToCity[i] <= i) return i;
        }

        return n;
    }
}