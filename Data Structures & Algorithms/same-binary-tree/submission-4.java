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
    public boolean isSameTree(TreeNode a, TreeNode b) {
        Queue<TreeNode> q = new ArrayDeque<>();
        if(a == null && b == null){
            return true;
        }
        if(a != null && b != null){
            q.offer(a);
            q.offer(b);
        }else{
            return false;
        }
        TreeNode first, second = null;
        while(!q.isEmpty()){
            first = q.poll();
            second = q.poll();

            if(first.val != second.val)
                return false;
            
            //one is null and other isnt
            if(first.left == null && second.left != null || first.left != null && second.left == null
                || first.right == null && second.right != null 
                || first.right != null && second.right == null){
                    return false;
                }
            
            //if any one is null and the other isnt they are kicked
            //so if one isnt null, the other too isnt null now, so checking one is fine
            if(first.left != null){
                q.add(first.left);
                q.add(second.left);
            }
            if(first.right != null){
                q.add(first.right);
                q.add(second.right);
            }
        }
        return true;
    }
}
