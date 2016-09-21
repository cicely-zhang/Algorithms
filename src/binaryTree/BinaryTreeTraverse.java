package binaryTree;

import java.util.*;

public class BinaryTreeTraverse {
	
	public static List<List<Integer>> levelOrderTraverse(TreeNode root) {
		
		List<List<Integer>> retList = new ArrayList<List<Integer>>();
		if (root == null)
			return retList;
		
		LinkedList<TreeNode> tmpList = new LinkedList<TreeNode>();
		tmpList.add(root);
		
		while (!tmpList.isEmpty()) {
			
			List<Integer> levelList = new ArrayList<Integer>();
			int curLevelElements = tmpList.size();
			for (int i =0; i < curLevelElements; i ++) {
				TreeNode curNode = tmpList.removeFirst();
				levelList.add(curNode.val);
				
				if (curNode.left != null)
					tmpList.addLast(curNode.left);

				if (curNode.right != null)
					tmpList.addLast(curNode.right);
			}
			retList.add(levelList);
		}
		
		return retList;
	}
	
	public static List<List<Integer>> zigZagTraverse(TreeNode root) {
		
	}

}
