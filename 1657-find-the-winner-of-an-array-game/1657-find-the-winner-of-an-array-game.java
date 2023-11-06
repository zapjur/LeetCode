class Solution {
    public int getWinner(int[] arr, int k) {
        
        if(arr.length == 1) return Math.max(arr[0], arr[1]);

        if(arr.length <= k) return Arrays.stream(arr).max().getAsInt();

        int currWinner = arr[0];
        int wins = 0;

        for(int i = 1; i < arr.length; i++){
            if(currWinner > arr[i])
                wins++;

            else{
                currWinner = arr[i];
                wins = 1;
            }

            if(wins == k) return currWinner;
        }

        return currWinner;

    }
}