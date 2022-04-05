class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] res = new char[n][m];
        
        for(int i=0; i<m; i++){
            for(int j=n-1; j>=0; j--){
                if(box[i][j] == '#'){
                    int next = j+1;
                    while(next<n && box[i][next]=='.'){
                        next++;
                    }
                    if(next<n && box[i][next]=='.'){
                        box[i][j] = '.';
                        box[i][next] = '#';
                    }else if(next-1<n && box[i][next-1]=='.'){
                        box[i][j] = '.';
                        box[i][next-1] = '#';
                    }
                }
            }
        }
        
        int k = m-1;
        for(int i=0; i<m; i++){
            for(int j=n-1; j>=0; j--){
                res[j][k] = box[i][j];
            }
            k--;
        }
        
        return res;
    }
}