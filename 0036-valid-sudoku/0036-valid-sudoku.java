class Solution {
    public boolean isValidSudoku(char[][] board) {
    
        Set<Character> cols = null;
        Set<Character> rows = null;

        for(int i = 0; i < 9; i++) {

            cols = new HashSet<>();
            rows = new HashSet<>();

            for(int j = 0; j < 9; j++) {
                
                char row = board[i][j];
                char col = board[j][i];

                if(row != '.') {
                    if(rows.contains(row)) {
                        return false;
                    }
                    else {
                        rows.add(row);
                    }
                }

                if(col != '.') {
                    if(cols.contains(col)) {
                        return false;
                    }
                    else {
                        cols.add(col);
                    }
                }
            }
        }

        for(int i = 0; i < 9; i+=3) {
            for(int j = 0; j < 9; j+=3) {
                if(!checkSquare(i, j, board)) {
                    return false;
                }
            }
        }

        return true;

    }

    private boolean checkSquare(int i, int j, char[][] board) {
        Set<Character> nums = new HashSet<>();
        int iLimit = i+3;
        int jLimit = j+3;
        for(int id = i; id < iLimit; id++) {
            for(int jd = j; jd < jLimit; jd++) {
                if (board[id][jd] == '.') {
                    continue;
                }
                else if(nums.contains(board[id][jd])) {
                    return false;
                }

                nums.add(board[id][jd]);
            }
        }

        return true;
    }
}