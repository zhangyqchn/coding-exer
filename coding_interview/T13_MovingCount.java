package algorithm;

public class T13_MovingCount {
    public int movingCount(int m, int n, int k){

        boolean[][] visit = new boolean[m][n];
        return dfs(m, n, 0, 0, k, visit);
    }
    public int digitalSum(int x){
        int sum = 0;
        while(x > 0){
            sum += x%10;
            x /= 10;
        }
        return sum;
    }
    public int dfs(int m, int n, int i, int j, int k, boolean[][] visit){
        if (i >= m || j >= n || digitalSum(i) + digitalSum(j) > k || visit[i][j] == true) return 0;
        visit[i][j] = true;
        return 1 + dfs(m, n, i + 1, j, k, visit) + dfs(m, n, i, j + 1, k, visit);
    }

}
