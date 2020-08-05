/*
package algorithm;

public class T24_ReverseList {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        LinkedList<ListNode> st1 = new LinkedList<>();
        ListNode temp = head;
        while(temp != null){
            st1.push(temp);
            temp = temp.next;
        }
        head = st1.pop();
        temp = head;
        while(!st1.isEmpty()){
            temp.next = st1.pop();
            temp = temp.next;
        }
        return head;
    }
}
*/
