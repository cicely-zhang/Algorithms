package binaryTree;

import java.util.Arrays;

public class TreeNode {

	public TreeNode left;
	public TreeNode right;
	public int val;
	
	public TreeNode(int value) {
		this.left = null;
		this.right = null;
		this.val = value;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null)
			return false;
		
		if (!TreeNode.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		
		TreeNode other = (TreeNode) obj;
		if (this.val != other.val)
			return false;
		
		boolean isEqual = true;
		if (this.left != null)
			isEqual = isEqual & this.left.equals(other.left);
		else if (this.left == null && other.left != null)
			return false;
		
		if (this.right != null)
			isEqual = isEqual & this.right.equals(other.right);
		else if (this.right == null && other.right != null)
			return false;
		
		return isEqual;
	}
	
	@Override
	public int hashCode() {
		
		int hash = this.val + (this.left != null ? this.left.hashCode() : 0) + (this.right != null ? this.right.hashCode() : 0);
		
		return hash;
	
	}
}