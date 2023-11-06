class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length -  1;
        int lMax = height[left];
        int rMax = height[right];

        int water = 0;

        while(left < right){
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);

            water += (lMax < rMax) ? lMax - height[left++] : rMax - height[right--];    
        }

        return water;
    }
}