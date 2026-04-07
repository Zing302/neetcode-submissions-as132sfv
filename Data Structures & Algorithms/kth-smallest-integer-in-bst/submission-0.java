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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr=new ArrayList<Integer>();
        dfs(root,k,arr);
        Collections.sort(arr);
        return arr.get(k-1);
    }

    public void dfs(TreeNode root,int k, List<Integer> arr){
        if(root==null){
            return;
        }
        arr.add(root.val);
        dfs(root.left,k,arr);
        dfs(root.right,k,arr);
    }
}
