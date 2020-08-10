package algorithm;

public class T29_SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return new int[0];
        int n = matrix[0].length;
        int[] res = new int[m*n];
        int l = 0, r = n - 1, t = 0, b = m - 1;
        int k = 0;
        while(true){
            for(int j = l; j <= r; j ++){
                res[k++] = matrix[t][j];
            }
            if(++t > b) break;
            for(int i = t; i <= b; i ++){
                res[k++] = matrix[i][r];
            }
            if(--r < l) break;
            for(int j = r; j >= l; j --){
                res[k++] = matrix[b][j];
            }
            if(--b < t) break;
            for(int i = b; i >= t; i --){
                res[k++] = matrix[i][l];
            }
            if(++l > r) break;
        }
        return res;
    }
}
