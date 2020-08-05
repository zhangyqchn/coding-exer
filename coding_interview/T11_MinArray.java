package algorithm;

public class T11_MinArray {     //11.旋转数组的最小数字
    public int minArray(int[] numbers){
        int n = numbers.length;
        if(n < 1) return -1;
        if(n < 2) return numbers[0];
        for(int i = 1; i < n; i ++){
            if(numbers[i - 1] > numbers[i])
                return numbers[i];
        }
        return numbers[0];
    }
}
