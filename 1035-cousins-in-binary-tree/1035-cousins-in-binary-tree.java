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
public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(x, root);
        TreeNode yy = findNode(y, root);
        return (level(root,xx,0) == level(root,yy,0) && (!isSibling(root,xx,yy)));

    }

    private TreeNode findNode(int x, TreeNode node){
        if(node == null) return null;

        if(node.val == x){
            return node;
        }
        TreeNode n = findNode(x, node.left);
        if(n!= null){
            return n;
        }
        return findNode(x, node.right);
    }

    private int level(TreeNode node, TreeNode xy, int start ){
        if(node == null) return 0;

        if(node == xy) return start;
        int l = level(node.left, xy, start+1);
        if(l != 0) return l;

        return level(node.right,xy,start+1);
    }


    private boolean isSibling(TreeNode node, TreeNode xx, TreeNode yy){
        if(node == null) return  false;

        return (node.left == xx && node.right == yy) || (node.left == yy && node.right == xx) || isSibling(node.left,xx,yy) || isSibling(node.right,xx,yy);



    }
}