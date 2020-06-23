// valid binary search tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class IsValidBST {
    public boolean isValidBST0(TreeNode root) {
        if(root == null) return true;
        ArrayList<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i) >= list.get(i+1)) return false;
        }
        return true;
    }
    public void inorder(TreeNode root, ArrayList<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
	
	boolean flag = false;
    int preval;
    public boolean isValidBST1(TreeNode root) {
        if(root == null) return true;
        if(!flag){
            TreeNode minNode = root;
            while(minNode.left != null){
                minNode = root.left;
            }
            preval = minNode.val - 1;
            flag = true;
        }
        if((!isValidBST(root.left)) || preval >= root.val) return false;
        preval = root.val;
        return isValidBST(root.right);
    }
	
	int preval = -2147483648;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if((!isValidBST(root.left)) || preval >= root.val) return false;
        preval = root.val;
        return isValidBST(root.right);
    }  
}
