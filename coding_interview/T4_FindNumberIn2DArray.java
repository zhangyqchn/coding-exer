package algorithm;

public class T4_FindNumberIn2DArray {
    public boolean findNumberIn2DArray0(int[][] matrix, int target) {   //动态规划
        int m = matrix.length;
        if(m < 1) return false;
        int n = matrix[0].length;
        if(n < 1) return false;
        int i = 0;
        int j = n - 1;
        while(i < m && j > -1){
            if(target == matrix[i][j]) return true;
            if(target < matrix[i][j]){
                j --;
            }
            else{
                i ++;
            }
        }
        return false;
    }
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {   //暴力
        for(int[] i : matrix){
            for(int j : i){
                if( j == target) return true;
            }
        }
        return false;
    }
}
