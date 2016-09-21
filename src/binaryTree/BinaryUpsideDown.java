package binaryTree;


public class BinaryUpsideDown {
	
	/*Cicely attempt 1
	 * 
	public static TreeNode head = null;
	
	
	public static TreeNode flipUpsideDown(TreeNode root) {

		if (root != null)
			flipUpsideDownHelper(root);
		return head;
	}
	
	private static TreeNode flipUpsideDownHelper(TreeNode root) {
		
		if (root.left == null && root.right == null) {
			return root;
		}
		
		TreeNode node1 = flipUpsideDownHelper(root.left);
		if (head == null)
			head = node1;
		
		node1.left = root.right;
		node1.right = root;
		root.left = null;
		root.right = null;
		
		return root;
	}
	
	*/
	
	//Improve: remove static variable
	public static TreeNode flipUpsideDown(TreeNode root) {
		
		if (root == null || root.left == null) {
			return root;
		}
		
		TreeNode newRoot = flipUpsideDown(root.left);
		root.left.left = root.right;
		root.left.right = root;
		
		root.left = null;
		root.right = null;
		return newRoot;
	}
	
	//To do: add the call in iteration
	/*public static TreeNode flipUpsideDownStack(TreeNode root) {
		
	} */
}