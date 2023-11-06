class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int currIndex = 0;

        for(int i = 1; i <= n; i++){
            if(currIndex >= target.length) break;

            if(target[currIndex] == i ){
                operations.add("Push");
                currIndex++;
            }
            else{
                operations.add("Push");
                operations.add("Pop");
            }
        }

        return operations;
    }
}