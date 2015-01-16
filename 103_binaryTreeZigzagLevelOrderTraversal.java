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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root==null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        int level = 1;
        List<Integer> item = new ArrayList<Integer>();
        item.add(root.val);
        res.add(item);
        stack.push(root);
        while (!stack.isEmpty()) {
            LinkedList<TreeNode> newStack = new LinkedList<TreeNode>();
            item = new ArrayList<Integer>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (level%2==0) {
                    if (node.left!=null) {
                        newStack.push(node.left);
                        item.add(node.left.val);
                    }
                    if (node.right!=null) {
                        newStack.push(node.right);
                        item.add(node.right.val);
                    }
                } else {
                    if (node.right!=null) {
                        newStack.push(node.right);
                        item.add(node.right.val);
                    }
                    if (node.left!=null) {
                        newStack.push(node.left);
                        item.add(node.left.val);
                    }
                }
            }
            level++;
            if (item.size()>0) {
                res.add(item);
            }
            stack = newStack;
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
    
    private Map<Integer, ArrayList<Integer>> maps = new TreeMap<Integer, ArrayList<Integer>>();
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        zigzag(root, 0);
        return new ArrayList<List<Integer>>(maps.values());
    }
    
    public void zigzag(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        
        if (maps.containsKey(level) == false) {
            maps.put(level, new ArrayList<Integer>());
        }
        
        if (level%2==1) {
            maps.get(level).add(0, node.val);
        } else {
            maps.get(level).add(node.val);
        }
        
        zigzag(node.left, level+1);
        zigzag(node.right, level+1);
    }
}