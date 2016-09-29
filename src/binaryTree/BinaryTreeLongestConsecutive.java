package binaryTree;

public class BinaryTreeLongestConsecutive {
	
	public static int longestConsecutive(TreeNode node) {
		int longest = 0;
		longestConsecutiveHelper(node, longest);
		return longest;
	}
	
	private static boolean longestConsecutiveHelper(TreeNode root, int longest) {
		
		if (root == null)
			return true;
		
		boolean isLeftConsecutive = longestConsecutiveHelper(root.left, longest);
		if (isLeftConsecutive && ((root.left != null && root.left.val-1 == root.val) || root.left == null)) {
			longest ++;
			return true;
		}
		
		int leftLongest = longest;
		boolean isRightConsecutive = longestConsecutiveHelper(root.right, longest);
		if (isRightConsecutive && ((root.right != null && root.right.val-1 == root.val) || root.right == null)) {
			longest ++;
			return true;
		}
		
		return false;
	}

}
