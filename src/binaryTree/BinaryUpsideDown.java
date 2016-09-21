package binaryTree;


public class BinaryUpsideDown {
	
	public TreeNode flipUpsideDown(TreeNode root) {
		
		TreeNode head = null;
		flipUpsideDownHelper(root, head);
		return head;
	}
	
	private TreeNode flipUpsideDownHelper(TreeNode root, TreeNode head) {
		if (root == null)
			return root;
		
		else if (root.left == null && root.right == null) {
			return root;
		}
		
		TreeNode node1 = flipUpsideDown(root.left);
		if (head == null)
			head = node1;
		
		node1.left = root.right;
		node1.right = root;
		
		return root;
	}
}