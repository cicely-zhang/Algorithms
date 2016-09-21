package binaryTree;

import java.util.*;

public class BinaryTreeConstructor {
	
	public static TreeNode construct(Integer[] treeList) {
		if (treeList.length == 0) 
			return null;
		
		TreeNode root = new TreeNode(treeList[0]);
		return constructHelper(treeList, root, 0);
	}
	
	private static TreeNode constructHelper(Integer[] treeList, TreeNode root, int curIndex) {
		if (root == null)
			return root;
		
		if (2*curIndex + 1 < treeList.length) {
			root.left = constructHelper(treeList, root.left, 2*curIndex + 1);
		}
		if (2*curIndex + 2 < treeList.length) {
			root.right = constructHelper(treeList, root.right, 2*curIndex + 2);
		}
		return root;
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
				tmpList.addLast(node.left);
				tmpList.addLast(node.right);
			}
		}
		
		return retList;
		
	}
	
	public static void main(String[] args) {
		Integer[] treeList = new Integer[] {1,2,2,3,3,3,3,4};
		TreeNode root = BinaryTreeConstructor.construct(treeList);
		
		List<Integer> listToPrint = BinaryTreeConstructor.treeToList(root);
		System.out.println(Arrays.toString(listToPrint.toArray()));
	}

}
