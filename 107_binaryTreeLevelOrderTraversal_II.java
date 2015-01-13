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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int lastNum = 1;
        int curNum = 0;
        int level = 0;
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode n = queue.pop();
            if (res.size()<=level) {
                res.add(new ArrayList<Integer>());
            }
            res.get(level).add(n.val);
            lastNum--;
            if (n.left != null) {
                queue.add(n.left);
                curNum++;
            }
            if (n.right != null) {
                queue.add(n.right);
                curNum++;
            }
            if (lastNum == 0) {
                level++;
                lastNum = curNum;
                curNum = 0;
            }
        }
        List<Integer> temp = new ArrayList<Integer>();
        int size = res.size();
        for (int i=0; i<size/2; i++) {
            temp = res.get(i);
            res.set(i,res.get(size-1-i));
            res.set(size-1-i, temp);
        }
        return res;
    }
}