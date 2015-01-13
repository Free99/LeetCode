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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int curNum = 0;
        int lastNum = 1;
        List<Integer> list = new ArrayList<Integer>();
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            lastNum--;
            list.add(cur.val);
            if (cur.left!=null){
                queue.add(cur.left);
                curNum++;
            }
            if (cur.right!=null){
                queue.add(cur.right);
                curNum++;
            }
            if (lastNum==0) {
                lastNum = curNum;
                curNum = 0;
                res.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return res;
    }
}