package algorithm;

public class T26_IsSubStructure {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        return judge(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    public boolean judge(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return judge(A.left, B.left) && judge(A.right, B.right);
    }
}
