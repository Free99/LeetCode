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
    public void recoverTree(TreeNode root) {
        if (root==null) {
            return;
        }
        List<TreeNode> pre = new ArrayList<TreeNode>();
        pre.add(null);
        List<TreeNode> res = new ArrayList<TreeNode>();
        helper(root, pre, res);
        if(res.size()>0) {
            int temp = res.get(0).val;
            res.get(0).val = res.get(1).val;
            res.get(1).val =temp;
        }
    }
    private void helper(TreeNode root, List<TreeNode> pre, List<TreeNode> res) {
        if (root==null) {
            return;
        }
        helper(root.left, pre, res);
        if (pre.get(0)!=null && pre.get(0).val>root.val) {
            if (res.size()==0) {
                res.add(pre.get(0));
                res.add(root);
            } else {
                res.set(1, root);
            }
        }
        pre.set(0, root);
        helper(root.right, pre, res);
    }
}