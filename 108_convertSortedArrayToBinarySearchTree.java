/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return rec(num, 0, num.length-1);
    }
    
    public TreeNode rec(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = rec(num, low, mid-1);
        root.right = rec(num, mid+1, high);
        return root;
    }
}