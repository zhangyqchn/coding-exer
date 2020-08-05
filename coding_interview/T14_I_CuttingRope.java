package algorithm;

public class T14_I_CuttingRope {
    public int cuttingRope(int n){  //数学推导：推论一： 将绳子 以相等的长度等分为多段 ，得到的乘积最大。
                                    //推论二： 尽可能将绳子以长度 33 等分为多段时，乘积最大。
        // 所以，切分规则如下：
        //最优： 3 。把绳子尽可能切为多个长度为 3 的片段，留下的最后一段绳子的长度可能为 0,1,2 三种情况。
        //次优： 2 。若最后一段绳子长度为 2 ；则保留，不再拆为 1+1 。
        //最差： 1 。若最后一段绳子长度为 1 ；则应把一份 3+1 替换为 2+2，因为 2×2>3×1。
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int t3 = n / 3;
        if(n % 3 == 1)
            t3 --;
        int t2 = (n - t3 * 3) / 2;
        int res = (int)(Math.pow(3, t3) * Math.pow(2, t2));
        return res;
    }
}
