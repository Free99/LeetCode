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
 	public TreeNode UpsideDownBinaryTree(TreeNode root) {
 		Stack<TreeNode> stack = new Stack<TreeNode>();

 		if (root == null) {
 			return null;
 		}
 		while (root.left != null) {
 			stack.push(root);
 			root = root.left;
 		}
 		stack.push(root);
 		while (!stack.empty()) {
 			TreeNode node = stack.pop();
 			if (!stack.empty()) {
 				node.right = stack.peek();
 				node.left = stack.peek().right;
 			} else {
 				node.left = null;
 				node.right = null;
 			}
 		}
 		return root;
 	}
 }