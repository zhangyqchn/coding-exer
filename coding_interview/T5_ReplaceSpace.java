package algorithm;

public class T5_ReplaceSpace {
    public String replaceSpace0(String s){  //一般思路
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray()){
            if(c == ' ' ){
                res.append("%20");
            }
            else{
                res.append(c);
            }
        }
        return res.toString();
    }

    public String replaceSpace1(String s) {   //直接调用函数
        return s.replaceAll(" ", "%20");
    }
}
