package algorithm;

import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class T7_BuildTree {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int x) {val = x;}

        public String toString(){
            return "val = " + val;
        }
    }
    HashMap<Integer, Integer> indict = new HashMap<>();
    int[] preo;
    int[] nexto;
    public TreeNode buildTree(int[] preorder, int[] inorder){   //先序+中序
        if(preorder.length == 0) return null;
        int n = inorder.length;
        preo = preorder;
        for(int i = 0; i < n; i ++){
            indict.put(inorder[i], i);
        }
        return buildTree(0, 0, n - 1);
    }
    TreeNode buildTree(int prestart, int instart, int inend){
        if(instart > inend || !indict.containsKey(preo[prestart])) return null;
        TreeNode root = new TreeNode(preo[prestart]);
        int inmid = indict.get(preo[prestart]);
        root.left = buildTree(prestart + 1, instart, inmid - 1);
        root.right = buildTree(prestart + inmid - instart + 1, inmid + 1, inend);
        return root;
    }
    public TreeNode buildTree1(int[] nextorder, int[] inorder){  //后序+中序
        int n = nextorder.length;
        if(n < 1) return null;
        nexto = nextorder;
        for(int i = 0; i < n; i ++){
            indict.put(inorder[i], i);
        }
        return buildTree1(n - 1, 0, n - 1);
    }
    TreeNode buildTree1(int nextend, int instart, int inend){
        if(instart > inend || !indict.containsKey(nexto[nextend])) return null;
        TreeNode root = new TreeNode(nexto[nextend]);
        int inmid = indict.get(nexto[nextend]);
        root.right = buildTree1(nextend - 1, inmid + 1, inend);
        root.left = buildTree1(nextend -1 - inend + inmid, instart, inmid - 1);
        return root;
    }
}
