class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat == null || mat.length == 0){
            return new int[0];
        }
        
        int m = mat.length;
        int n = mat[0].length;
        int row = 0;
        int col = 0;
        boolean up = true;
        int i = 0;
        int[] res = new int[m*n];
        
        while(row<m && col<n){
            if(up){
                while(row>0 && col<n-1){
                    res[i++] = mat[row][col];
                    row--;
                    col++;
                }
                res[i++] = mat[row][col];
                if(col == n-1)
                    row++;
                else
                    col++;
            }else{
                while(col>0 && row<m-1){
                    res[i++] = mat[row][col];
                    row++;
                    col--;
                }
                res[i++] = mat[row][col];
                if(row == m-1)
                    col++;
                else
                    row++;
            }
            up=!up;
        }
        
        return res;
    }
}