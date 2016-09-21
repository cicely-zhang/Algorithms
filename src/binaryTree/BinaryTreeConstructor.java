package binaryTree;

public class BinaryTreeConstructor {
	
	public static TreeNode construct(Integer[] treeList) throws Exception {
		if (treeList.length == 0) 
			return null;
		
		TreeNode root = new TreeNode(treeList[0]);
		TreeNode rootClone = root;
		int i = 0;
		while (i < treeList.length) {
			if (2*i + 1 >= treeList.length)
				break;
			
			if (treeList[2*i + 1] == null)
				rootClone.left = null;
			else 
				rootClone.left = new TreeNode(treeList[2*i + 1]);
			
			if (2*i + 2 >= treeList.length)
				break;
			
			if (treeList[2*i + 2] == null)
				rootClone.right = null;
			else 
				rootClone.left = new TreeNode(treeList[2*i + 2]);
			
			i++;
			
		}
	}

}
