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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res=new ArrayList<>();
        dfsSerialize(root,res);
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data=data.replace("[","").replace("]","").replace(" ","");
        String[] list=data.split(",");
        int[] ind=new int[]{0};
        TreeNode res=dfsDeserialize(new TreeNode(),list,ind);
        return res;
    }
    public void dfsSerialize(TreeNode root, List<String> res){
        if(root==null){
            res.add("#");
            return;
        }else{
            res.add(""+root.val);
            dfsSerialize(root.left,res);
            dfsSerialize(root.right,res);
        }
    }

    public TreeNode dfsDeserialize(TreeNode root, String[] data,int[] ind){
        if(data[ind[0]].equals("#")){
            ind[0]++;
            return null;
        }
        root=new TreeNode(Integer.parseInt(data[ind[0]]));
        ind[0]++;
        root.left=dfsDeserialize(root.left,data,ind);
        root.right=dfsDeserialize(root.right,data,ind);
        return root;
    }

}
