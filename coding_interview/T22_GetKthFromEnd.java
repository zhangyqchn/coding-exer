package algorithm;

public class T22_GetKthFromEnd {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
    public ListNode getKthFromEnd(ListNode head, int k){
        ListNode first = head, second = head;
        for(int i = 0; i < k; i ++){
            first = first.next;
        }
        while(first != null){
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
