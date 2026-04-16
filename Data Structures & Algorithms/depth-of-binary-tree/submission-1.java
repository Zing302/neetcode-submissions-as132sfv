/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        int cnt=dfs(root,0);
        return cnt;
    }

    public int dfs(TreeNode root,int num){
        if(root==null){
            return 0;
        }else{
            return 1+ Math.max(dfs(root.right,num),dfs(root.left,num));
        }
    }
}

