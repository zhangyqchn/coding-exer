package algorithm;

public class T16_MyPow {
    public double myPow1(double x, int n) {      //递归
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return x;
        long b = n;
        if (b < 0) {
            x = 1/x;
            b = -b;
        }
        double res = myPow1(x, (int)(b/2));
        res *= res;
        if ((b & 1) == 1)
            res *= x;
        return res;
    }
    public double myPow2(double x, int n) {  //快速幂：二分法
        // 设res=1，则初始化状态为 x^n * res。在循环二分时，每当n为奇数时，将多出的一项x乘入res，则最终可至x^0 * res = res，返回res即可。
        //例：循环轮数，(res) * x^n
        //   第0轮，  (1) * 3^5
        //   第1轮，  (1 * 3) * 9^2
        //   第2轮，  (1 * 3) * 81^1
        //   第3轮，  (1 * 3 * 81) * 6561^0
        //返回res
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return x;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        double res = 1.0;
        while (b > 0){
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
