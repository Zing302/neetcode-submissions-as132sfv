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
    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }
    private TreeNode dfs(TreeNode root){
        if(root==null){
            return null;
        }
        if(root!=null){
                TreeNode temp=root.left;
                root.left=root.right;
                root.right=temp;
            
            root.left=dfs(root.left);
            root.right=dfs(root.right);
        }
        return root;
    }
}
