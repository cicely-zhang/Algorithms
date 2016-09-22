package binaryTree;

import java.util.*;
import binaryTree.*;

public class BinaryTreeSerializer {

	public String serialize(TreeNode root) {
        List<Integer> retList = new ArrayList<Integer>();
		if (root == null)
			return retList.toString();
		
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
		int listSize = retList.size();
		while (retList.get(listSize - 1) == null) {
			retList.remove(listSize -1);
			listSize --;
		}
		
		return retList.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        Integer[] treeList = getTreeList(data);
        if (treeList == null || treeList.length == 0) 
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
	
	private Integer[] getTreeList(String data) {
	    
	    data = data.replace("[", "");
        data = data.replace("]", "");
        
        if ((data = data.trim()).equals(""))
        		return null;
            
        String[] dataArr = data.split(",");
        Integer[] treeList = new Integer[dataArr.length];
        for (int i = 0; i < dataArr.length; i ++) {
            String ele = dataArr[i].trim();
            if (ele.equals("null")) 
                treeList[i] = null;
            else 
                treeList[i] = Integer.parseInt(ele);
        }
        return treeList;
	}
}
