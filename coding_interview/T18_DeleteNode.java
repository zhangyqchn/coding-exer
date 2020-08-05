package algorithm;

import java.util.List;

public class T18_DeleteNode {   //18.删除链表的节点
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
    public ListNode deleteNode(ListNode head, int val) {    //双指针
        ListNode node = new ListNode(1);
        if(head == null) return head;
        if(head.val == val){
            head = head.next;
            return head;
        }
        ListNode temp = head.next, pre = head;
        while(temp != null){
            if(temp.val == val){
                pre.next = temp.next;
                break;
            }
            pre = temp;
            temp = temp.next;
        }
        return head;
    }
    public ListNode deleteNode1(ListNode head, int val){    //单指针
        if(head == null) return head;
        if(head.val == val) return head.next;
        ListNode temp = head;
        while(temp.next != null){
            if(temp.next.val == val){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
}
