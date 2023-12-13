class Solution {
    public int numSpecial(int[][] mat) {
        int res = 0;
        for(int[] row : mat){
            if(rowSum(row) == 1){
                int id = 0;
                for(; id<row.length; id++){
                    if(row[id] == 1) break;
                }
                res += colSum(mat, id) == 1 ? 1 : 0; 
            }
        }
        return res;
    }
    private int rowSum(int[] row){
        int sum = 0;
        for(int num : row) sum+= num;

        return sum;
    }
    private int colSum(int[][] mat, int id){
        int sum = 0;
        for(int[] row : mat){
            sum += row[id];
        }
        return sum;
    }
}