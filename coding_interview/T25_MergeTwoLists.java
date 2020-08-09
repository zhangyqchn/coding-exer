package algorithm;

public class T25_MergeTwoLists {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){val = x;}
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0), temp = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            }
            else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 != null ? l1 : l2;
        return head.next;
    }
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        ListNode cur = l1, pre = null;
        while(cur != null && l2 != null){
            if(cur.val > l2.val){
                ListNode temp = l2;
                l2 = l2.next;
                temp.next = cur;
                if(pre == null){
                    pre = temp;
                    l1 = pre;
                }
                else{
                    pre.next = temp;
                    pre = pre.next;
                }
            }
            else{
                pre = cur;
                cur = cur.next;
            }
        }
        if(cur == null){
            pre.next = l2;
        }
        return l1;
    }
    public ListNode initial(int[] nums){
        if(nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
//        if(nums.length == 1) return head;
        ListNode cur = head;
        for(int i = 1; i < nums.length; i ++){
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }
    public void display(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
