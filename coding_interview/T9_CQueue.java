package algorithm;

import java.util.LinkedList;

public class T9_CQueue {
    LinkedList<Integer> st1;
    LinkedList<Integer> st2;
    public T9_CQueue(){
        st1 = new LinkedList<>();
        st2 = new LinkedList<>();
    }
    public void appendTail(int value){
        st1.push(value);

    }
    public int deleteHead(){
        if(st2.isEmpty()){
            if(st1.isEmpty()) return -1;
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }
}
