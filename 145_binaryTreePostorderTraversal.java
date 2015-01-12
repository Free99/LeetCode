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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode pre = null;
        while(!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (pre == null || pre.left == cur || pre.right == cur) {
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    res.add(cur.val);
                    stack.pop();
                }
            } else if (cur.left == pre && cur.right != null) {
                stack.push(cur.right);
            } else {
                res.add(cur.val);
                stack.pop();
            }
            pre = cur;
        }
        return res;
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode peekNode = stack.peek();
                if (peekNode.right != null && pre != peekNode.right) {
                    root = peekNode.right;
                } else {
                    stack.pop();
                    res.add(peekNode.val);
                    pre = peekNode;
                }
            }
        }
        return res;
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode cur = dummy;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    reverse(cur.left, pre);
                    TreeNode temp = pre;
                    while (temp != cur.left) {
                        res.add(temp.val);
                        temp = temp.right;
                    }
                    res.add(temp.val);
                    reverse(pre, cur.left);
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
    private void reverse(TreeNode start, TreeNode end) {
        if (start == end) {
            return;
        }
        TreeNode pre = start;
        TreeNode cur = start.right;
        TreeNode next;
        while (pre != end) {
            next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
    }
}