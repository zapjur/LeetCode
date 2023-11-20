class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int timeSum = 0;

        for(String g : garbage){
            timeSum += g.length();
        }

        boolean m = false, p = false, g = false;

        for(int i = travel.length; i > 0; i--){
            m = m || garbage[i].contains("M");
            p = p || garbage[i].contains("P");
            g = g || garbage[i].contains("G");

            timeSum += travel[i-1] * ((m ? 1:0) + (p ? 1:0) + (g ? 1:0));

        }
        return timeSum;
    }
}