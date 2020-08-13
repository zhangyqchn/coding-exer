package algorithm;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class T32_I_LevelOrder {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public int[] levelOrder(TreeNode root){
        if(root == null) return new int[0];
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            TreeNode temp = que.poll();
            if(temp != null){
                list.add(temp.val);
                que.offer(temp.left);
                que.offer(temp.right);
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for(int a : list){
            res[i] = a;
            i ++;
        }
        return res;
    }
}
