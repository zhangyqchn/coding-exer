package algorithm;

public class T20_IsNumber {
    public boolean isNumber(String s){
        if(s == null || s.length() == 0) return false;
        char[] str = s.trim().toCharArray();
        boolean numSeen = false, eSeen = false, dotSeen = false;
        for(int i = 0; i < str.length; i ++){
            if(str[i] >= '0' && str[i] <= '9'){
                numSeen = true;
            }
            else if(str[i] == '.'){
                if(dotSeen || eSeen) return false;
                dotSeen = true;
            }
            else if(str[i] == 'e' || str[i] == 'E'){
                if(eSeen || !numSeen){
                    return false;
                }
                eSeen = true;
                numSeen = false;
            }
            else if(str[i] == '+' || str[i] == '-'){
                if(i != 0 && str[i-1] != 'e' && str[i-1] != 'E'){
                    return false;
                }
            }
            else return false;
        }
        return numSeen;
    }
}
