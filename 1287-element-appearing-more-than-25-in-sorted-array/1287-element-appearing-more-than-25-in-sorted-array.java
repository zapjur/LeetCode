class Solution {
    public int findSpecialInteger(int[] arr) {
        int size = arr.length;
        int q = size/4;

        for(int i = 0; i < size - q; i++){
            if(arr[i] == arr[i+q]) return arr[i];
        }
        return -1;
    }
}