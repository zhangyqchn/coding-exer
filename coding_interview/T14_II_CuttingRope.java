package algorithm;

public class T14_II_CuttingRope {
    public int cuttingRope(int n){
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int t3 = n / 3;
        if (n % 3 == 1) t3 --;
        int t2 = (n - t3 * 3) / 2;
        long res = 1;
        while (t3 > 0){     //为正确存储数值，需要long类型变量（int类型最大到2,147,483,647）
            res *= 3;
            t3 --;
            if (res > 1000000007) res %= 1000000007;
        }
        while (t2 > 0){
            res *= 2;
            t2 --;
            if (res > 1000000007) res %= 1000000007;
        }
        return (int)res;
    }
}
