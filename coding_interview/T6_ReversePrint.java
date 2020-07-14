package algorithm;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class T6_ReversePrint {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public int[] reversePrint0(ListNode head) { //入栈出栈
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode currentNode = head;
        while(currentNode != null){
            stack.push(currentNode);
            currentNode = currentNode.next;
        }
        int n = stack.size();
        int[] res = new int[n];
        for(int i = 0; i < n; i ++){
            res[i] = stack.pop().val;
        }
        return res;
    }

    ArrayList<Integer> list = new ArrayList<Integer>();
    void recur(ListNode node){
        if (node == null)
            return;
        recur(node.next);
        list.add(node.val);
    }
    public int[] reversePrint1(ListNode head){
        recur(head);
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i ++){
            res[i] = list.get(i);
        }
        return res;
    }
}
