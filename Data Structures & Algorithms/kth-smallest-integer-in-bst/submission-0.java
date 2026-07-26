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
        int result[] = new int[1];
        getKthSmallest(root, k, new int[]{0}, result);
        return result[0];
    }

    public void getKthSmallest(TreeNode node, int k, int[] count, int[] result){
        if(node == null){
            return;
        }
        getKthSmallest(node.left, k, count, result);
        count[0]++;
        if(count[0] == k){
            result[0] = node.val;
            return;
        }
        getKthSmallest(node.right, k, count, result);
    }
}
