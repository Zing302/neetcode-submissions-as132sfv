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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        levelOrder(list,0,root);
        return list;
    }

    public void levelOrder(List<List<Integer>> list,int level,TreeNode root){
        if(root==null){
            return;
        }
        if(list.size()==level){
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        levelOrder(list,level+1,root.left);
        levelOrder(list,level+1,root.right);
    }
}
