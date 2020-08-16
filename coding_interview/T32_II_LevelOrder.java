package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T32_II_LevelOrder {
    int N = 0;
    Integer[] nums;
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public TreeNode build(Integer[] nums){  //队列
        int n = nums.length;
        if(n == 0) return null;
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int i = 1;
        while(i < n){
            TreeNode node = que.poll();
            if(node == null) continue;
            node.left = null;
            if(nums[i] != null){
                node.left = new TreeNode(nums[i]);
            }
            que.offer(node.left);
            node.right = null;
            i ++;
            if(i >= n) break;
            if(nums[i] != null){
                node.right = new TreeNode(nums[i]);
            }
            que.offer(node.right);
            i ++;
        }
        return root;
    }
    public TreeNode build2(Integer[] nums){     // 递归
        N = nums.length;
        if(N == 0) return null;
        this.nums = nums;
        return recur(0);
    }
    public TreeNode recur (int i){
        TreeNode root = null;
        if(i < N && this.nums[i] != null){
            root = new TreeNode(this.nums[i]);
            root.left = recur(i * 2 + 1);
            root.right = recur(i * 2 + 2);
        }
        return root;
    }
    public TreeNode build3 (Integer[] nums){    // 计算下标
        N = nums.length;
        if(N == 0) return null;
        List<TreeNode> list = new ArrayList<>();
        for(Integer i : nums){
            if(i != null) list.add(new TreeNode(i));
            else list.add(null);
        }
        for(int i = 0; i < N/2; i ++){
            if(nums[i] != null){
                list.get(i).left = list.get(i*2+1);
                if(i*2+2 < N)
                    list.get(i).right = list.get(i*2+2);
            }
        }
        return list.get(0);
    }
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root != null) que.add(root);
        while (!que.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for(int i = que.size(); i > 0; i --){
                TreeNode node = que.poll();
                tmp.add(node.val);
                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
