/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root == p || root==q) return root;

        TreeNode leftL = lowestCommonAncestor(root.left,p,q);

        TreeNode rightL = lowestCommonAncestor(root.right,p,q);

        if(leftL !=null && rightL != null) return root;

        else if(leftL != null){
            return leftL;
        }
        else{
            return rightL;
        }
    }
}