package binaryTree;

import java.util.*;

public class BinaryTreeConstructor {
	
	public static TreeNode construct(Integer[] treeList) {
		if (treeList.length == 0) 
			return null;
		
		TreeNode root = new TreeNode(treeList[0]);
		constructHelper(treeList, root, 0);
		return root;
	}
	
	private static void constructHelper(Integer[] treeList, TreeNode root, int curIndex) {
		if (root == null)
			return;
		
		Integer leftVal;
		if (2*curIndex + 1 < treeList.length && (leftVal = treeList[2*curIndex + 1]) != null) {
			root.left = new TreeNode(leftVal); 
			constructHelper(treeList, root.left, 2*curIndex + 1);
		}
		Integer rightVal;
		if (2*curIndex + 2 < treeList.length && (rightVal = treeList[2*curIndex + 2]) != null) {
			root.right = new TreeNode(rightVal);
			constructHelper(treeList, root.right, 2*curIndex + 2);
		}
	}
	
	public static List<Integer> treeToList(TreeNode root) {
		
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
	
	public static void main(String[] args) {
		Integer[] treeList = new Integer[] {1, 2, 3, 3, null, null, 3, 4, null, null, null, 4};
		TreeNode root = BinaryTreeConstructor.construct(treeList);
		
		List<Integer> listToPrint = BinaryTreeConstructor.treeToList(root);
		System.out.println(Arrays.toString(listToPrint.toArray()));
	}

}
