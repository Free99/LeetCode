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
    public boolean isValidBST(TreeNode root) {
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(null);
        return helper(root, pre);
    }
    private boolean helper(TreeNode root, List<Integer> pre) {
        if (root==null) {
            return true;
        }
        boolean left = helper(root.left, pre);
        if (pre.get(0)!=null && root.val<=pre.get(0)) {
            return false;
        }
        pre.set(0, root.val);
        return left && helper(root.right, pre);
    }
}


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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    boolean helper(TreeNode root, int min, int max) {
        if (root==null) {
            return true;
        }
        if (root.val<=min || root.val>=max) {
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}