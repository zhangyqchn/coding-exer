package algorithm;

import java.util.*;

public class T34_PathSum {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    List<List<Integer>> res;
    int sum;
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        res = new ArrayList<>();
        List<Integer> nodes = new ArrayList<>();
        if (root == null) {
            return res;
        }
        this.sum = sum;
        recur(root, 0, nodes);
        return res;
    }
    public void recur(TreeNode root, int z, List<Integer> nodes){
        nodes.add(root.val);
        z += root.val;
        if(root.left == null && root.right == null){
            if(z == sum) {
                List<Integer> temp = new ArrayList<>(nodes);
                res.add(temp);
            }
        }
        if(root.left != null) {
            recur(root.left, z, nodes);
            nodes.remove(nodes.size() - 1);
        }
        if(root.right != null) {
            recur(root.right, z, nodes);
            nodes.remove(nodes.size() - 1);
        }
    }
    public TreeNode build(Integer[] nums){
        if(nums.length == 0) return null;
        Queue<Integer> q1 = new LinkedList<>();
        for(Integer i : nums){
            q1.offer(i);
        }
        TreeNode root = new TreeNode(q1.poll());
        Queue<TreeNode> q2 = new LinkedList<>();
        q2.offer(root);
        while(!q1.isEmpty()){
            TreeNode node = q2.poll();
            if(node != null) {
                Integer temp = q1.poll();
                if(temp != null) node.left = new TreeNode(temp);
                q2.offer(node.left);
                if(!q1.isEmpty()){
                    temp = q1.poll();
                    if(temp != null) node.right = new TreeNode(temp);
                    q2.offer(node.right);
                }
            }
        }
        return root;
    }
    public void display(TreeNode root){
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            TreeNode temp = que.poll();
            if(temp != null){
                System.out.print(temp.val + " ");
                que.offer(temp.left);
                que.offer(temp.right);
            }
            else
                System.out.print("null ");
        }
    }
}
