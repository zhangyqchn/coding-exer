package algorithm;

public class T10_I_Fib {
    public int fib(int n) { //动态规划
        if(n == 0) return 0;
        if(n == 1) return 1;
        int f0 = 0, f1 = 1;
        for(int i = 2; i <= n; i ++){
            // int temp = Math.floorMod(f0 + f1, 1000000007);
            int temp = (f0 + f1) % 1000000007;
            f0 = f1;
            f1 = temp;
        }
        return f1;
    }
}
