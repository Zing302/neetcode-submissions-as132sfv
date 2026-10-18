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
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return cnt;
    }
    public void dfs(TreeNode root, int maxNode){
        if(root==null){
            return;
        }
        if(root.val >= maxNode){
            cnt++;
        }
        dfs(root.left,Math.max(maxNode,root.val));
        dfs(root.right,Math.max(maxNode,root.val));
    }
}
