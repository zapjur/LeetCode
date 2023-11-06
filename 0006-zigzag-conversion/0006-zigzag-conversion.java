class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows < 2){
            return s;
        }

        String ans = "";
        int size = s.length();
        char matrix[][] = new char[numRows][size];
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < size; j++){
                matrix[i][j] = '!';
            }
        }

        for(int i = 0, direction = 1, row = 0; i < size; i++){
            matrix[row][i] = s.charAt(i);
            if(row == numRows - 1) direction = -1;
            else if(row == 0) direction = 1;
            row += direction;

        }

        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < size; j++){
                if(matrix[i][j] != '!') ans = ans + matrix[i][j];
            }
        }

        return ans;

    }
}