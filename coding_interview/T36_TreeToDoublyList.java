package algorithm;

public class T36_TreeToDoublyList {
    public class Node{
        int val;
        Node left;
        Node right;
        Node(){}
        Node(int _val){val = _val;}
        Node(int _val, Node _left, Node _right){
            val = _val;
            left = _left;
            right = _right;
        }
    }
    Node head, pre;
    public Node treeToDoublyList(Node root){
        if(root == null) return null;
        midOrder(root);
        pre.right = head;
        head.left = pre;
        return head;
    }
    public void midOrder(Node root){
        if(root == null) return;
        midOrder(root.left);
        if(pre == null) head = root;
        else pre.right = root;
        root.left = pre;
        pre = root;
        midOrder(root.right);
    }
}
