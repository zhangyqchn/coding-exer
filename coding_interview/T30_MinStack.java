package algorithm;

import java.util.LinkedList;

public class T30_MinStack {
    LinkedList<Integer> st;
    LinkedList<Integer> aux_st;

    public T30_MinStack(){
        st = new LinkedList<>();
        aux_st = new LinkedList<>();
    }

    public void push(int x){
        st.push(x);
        if (aux_st.isEmpty() || x <= aux_st.peek()) {
            aux_st.push(x);
        }
    }

    public void pop(){
        if(st.pop().equals(aux_st.peek()))
        {
            aux_st.pop();
        };
    }

    public int top(){
        return st.peek();
    }

    public int min(){
        return aux_st.peek();
    }
}
