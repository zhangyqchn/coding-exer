package algorithm;

import java.util.*;

public class T32_III_LevelOrder {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root != null) que.offer(root);
        boolean flag = false;
        while (!que.isEmpty()) {
            LinkedList<Integer> deque = new LinkedList<>();
            for(int i = que.size(); i > 0; i --){
                TreeNode node = que.poll();
                if(!flag){// 第1层开始，奇数层，正向
                    deque.addLast(node.val);
                }
                else {  // 偶数层，反向
                    deque.addFirst(node.val);
                }
                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);
            }
            res.add(deque);
            if(!flag) flag = true;
            else flag = false;
        }
        return res;
    }
}
