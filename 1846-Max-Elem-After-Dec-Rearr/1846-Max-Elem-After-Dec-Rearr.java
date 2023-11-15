class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] count = new int[n];

        for(int i = 0; i < n; i++){
            ++count[Math.min(arr[i]-1, n-1)];
        }
        int res = 1;

        for(int i = 1; i < n; i++){
            res = Math.min(i+1, res+count[i]);
        }

        return res;
    }
}