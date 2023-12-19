class Solution {
    public int[][] imageSmoother(int[][] img) {
        if (img == null || img.length == 0 || img[0].length == 0) return img;

        int rows = img.length;
        int cols = img[0].length;
        int[][] result = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                result[i][j] = calc(img, i, j);
            }
        }
        return result;
    }

    private int calc(int[][] img, int x, int y){
        int sum = 0;
        int count = 0;

        for(int i = x - 1; i <= x + 1; i++){
            for(int j = y - 1; j <= y + 1; j++){
                if(i >= 0 && i < img.length && j >= 0 && j < img[0].length){
                    sum += img[i][j];
                    count++;
                }
            }
        }
        return sum / count;
    }
}
