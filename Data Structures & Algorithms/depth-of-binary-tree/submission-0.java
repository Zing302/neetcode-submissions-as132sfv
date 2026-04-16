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
    int cnt=0;
    public int maxDepth(TreeNode root) {
        dfs(root,0);
        return cnt;
    }

    public void dfs(TreeNode root,int num){
        if(root==null){
            cnt=Math.max(cnt,num);
        }else{
            num++;
            dfs(root.right,num);
            dfs(root.left,num);
        }
    }
}

