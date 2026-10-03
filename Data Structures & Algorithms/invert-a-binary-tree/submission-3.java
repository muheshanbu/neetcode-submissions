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
 *     };
 * }
 */

class Solution {
     public TreeNode invertTree(TreeNode root) {
        TreeNode node = root;
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(node == null)
            return null;
        queue.offer(node);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            //swapping
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if(current.left != null) 
                queue.add(current.left);
            
            if(current.right != null)
                queue.add(current.right);
            
        }
        return root;
    }
}
