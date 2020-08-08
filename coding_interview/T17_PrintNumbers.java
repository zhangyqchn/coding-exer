package algorithm;

public class T17_PrintNumbers {
    int n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    StringBuilder res;
    public String printNumbers(int n){
        this.n = n;
        num = new char[n];      //设置num为长度位n的字符列表
        res = new StringBuilder();
        dfs(0);
        res.deleteCharAt(res.length() - 1);
        res.delete(0, 1);
        return res.toString();
    }
    public void dfs(int x){     //
        if (x == n){
            int offset = 0, count = n;
            int j = 0;
            while(j < n){
                if(num[j] != '0') break;
                offset ++;
                count --;
                j ++;
            }
            res.append(String.valueOf(num, offset, count) + ',');
            return;
        }
        for(char i : loop){
            num[x] = i;
            dfs(x + 1);
        }
    }
}
