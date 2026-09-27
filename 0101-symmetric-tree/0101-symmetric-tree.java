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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return isMir(root.left, root.right);
    }

    private boolean isMir(TreeNode LN, TreeNode RN){
        if(LN == null && RN == null) return true;
        if(LN == null || RN == null) return false;

        return LN.val == RN.val && isMir(LN.left, RN.right) && isMir(LN.right, RN.left);
    }
}