package algorithm;

import java.util.Stack;

public class T27_MirrorTree {
    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x){val = x;}
    }
    public TreeNode mirrorTree(TreeNode root){
        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
    public TreeNode mirrorTree2(TreeNode root){
        if(root == null) return null;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            if(temp.left != null) st.push(temp.left);
            if(temp.right != null) st.push(temp.right);
            TreeNode temp2 = temp.left;
            temp.left = temp.right;
            temp.right = temp2;
        }
        return root;
    }
}
