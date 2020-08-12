package algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class T31_ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped){
        if(pushed.length != popped.length) return false;
        if(pushed.length == 0) return true;
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        for(int x : pushed){
            stack.push(x);
            while (!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i ++;
            }
        }
        return stack.isEmpty();
    }
    public boolean validateStackSequences2(int[] pushed, int[] popped){
        if(pushed.length != popped.length) return false;
        if(pushed.length == 0) return true;
        int i = 0, j = 0;
        for(int x : pushed){
            pushed[i] = x;
            while(i >= 0 && pushed[i] == popped[j]){
                i --;
                j ++;
            }
            i ++;
        }
        return i == 0;
    }
}
