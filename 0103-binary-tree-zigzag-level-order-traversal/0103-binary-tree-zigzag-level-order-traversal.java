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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> listA = new ArrayList<>(levelSize);
            for(int i =0 ;i< levelSize;i++){
                TreeNode node = queue.poll();
                if(leftToRight){
                    listA.add(node.val);
                }
                else{
                    listA.add(0,node.val);
                }
                if(node.left != null ) queue.offer(node.left);
                if(node.right != null ) queue.offer(node.right);
            }
        res.add(listA);        
        leftToRight = !leftToRight;

        }
        return res;
    }
}