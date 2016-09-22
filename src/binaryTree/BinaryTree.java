package binaryTree;

import java.util.*;

public class BinaryTree {
	
	private TreeNode rootNode;
	
	public TreeNode getRootNode() {
		return rootNode;
	}
	
	public BinaryTree(Integer[] treeList) {
		rootNode = this.formTree(treeList);
	}
	
	public static TreeNode formTree(Integer[] treeList) {
		if (treeList.length == 0) 
			return null;
		
		TreeNode root = new TreeNode(treeList[0]);
		formTreeHelper(treeList, root, 0);
		return root;
	}
	
	private static void formTreeHelper(Integer[] treeList, TreeNode root, int curIndex) {
		if (root == null)
			return;
		
		Integer leftVal;
		if (2*curIndex + 1 < treeList.length && (leftVal = treeList[2*curIndex + 1]) != null) {
			root.left = new TreeNode(leftVal); 
			formTreeHelper(treeList, root.left, 2*curIndex + 1);
		}
		Integer rightVal;
		if (2*curIndex + 2 < treeList.length && (rightVal = treeList[2*curIndex + 2]) != null) {
			root.right = new TreeNode(rightVal);
			formTreeHelper(treeList, root.right, 2*curIndex + 2);
		}
	}
	
	public List<Integer> treeToList(TreeNode root) {
		
		List<Integer> retList = new ArrayList<Integer>();
		if (root == null)
			return retList;
		
		LinkedList<TreeNode> tmpList = new LinkedList<TreeNode>();
		tmpList.add(root);
		
		while (!tmpList.isEmpty()) {
			TreeNode node = tmpList.removeFirst();
			retList.add(node == null ? null : node.val);
			if (node != null) {
				if (node.left == null && node.right == null)
					continue;
				tmpList.addLast(node.left);
				tmpList.addLast(node.right);
			}
		}
		if (retList.get(retList.size()-1) == null) 
			retList.remove(retList.size()-1);

		return retList;
	}
	
	public boolean isValidBinarySearchTreeV1() {
		String validStr = isValidBinarySearchTreeHelperV1(this.rootNode);
		if (validStr == "")
			return false;
		
		return true;
	}

	private String isValidBinarySearchTreeHelperV1(TreeNode root) {
		
		if (root == null)
			return ",";
		
		if (root.left == null && root.right == null) {
			return String.format("%1$d,%2$d", root.val, root.val);
		}
		
		String leftValidStr = isValidBinarySearchTreeHelperV1(root.left);
		String rightValidStr = isValidBinarySearchTreeHelperV1(root.right);
		if (leftValidStr == "" || rightValidStr == "")
			return "";
		
		int leftMin = root.val;
		int leftMax = root.val;
		if (leftValidStr != ",") {
			String[] leftArr = leftValidStr.split(",");
			leftMin = Integer.parseInt(leftArr[0]);
			leftMax = Integer.parseInt(leftArr[1]);
		}
		
		int rightMin = root.val;
		int rightMax = root.val;
		if (rightValidStr != ",") {
			String[] rightArr = rightValidStr.split(",");
			rightMin = Integer.parseInt(rightArr[0]);
			rightMax = Integer.parseInt(rightArr[1]);
		}
		
		if (root.val < leftMax || root.val > rightMin)
			return "";
		
		return String.format("%1$d,%2$d", leftMin, rightMax);
		
	}
}
