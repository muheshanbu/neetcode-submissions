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
        if(a != null){
            q.offer(a);
        }else{
            return false;
        }
        if(b != null){
            q.offer(b);
        }else{
            return false;
        }
        TreeNode first, second = null;
        while(!q.isEmpty()){
            first = q.poll();
            second = q.poll();
            if(first == null || second == null){
                return false;
            }
            if(first.val != second.val)
                return false;
            if(first.left == null && second.left != null || first.left != null && second.left == null
                || first.right == null && second.right != null 
                || first.right != null && second.right == null){
                    return false;
                }
            if(first.left != null && second.left != null){
                q.add(first.left);
                q.add(second.left);
            }
            if(first.right != null && second.right != null){
                q.add(first.right);
                q.add(second.right);
            }
        }
        return true;
    }
}
