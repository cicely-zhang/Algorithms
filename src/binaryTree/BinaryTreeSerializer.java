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
        
    	 LinkedList<TreeNode> nodeQueue = parse(data);
         
         if (nodeQueue == null || nodeQueue.isEmpty())
             return null;
             
         TreeNode root = nodeQueue.removeFirst();
         deserializeHelper(nodeQueue, root);
         return root;
    }
    
    private void deserializeHelper(LinkedList<TreeNode> nodeQueue, TreeNode root) {
        
        if (root == null)
            return;
            
        TreeNode left = null;
        TreeNode right = null;
        
        if (!nodeQueue.isEmpty())
            left = nodeQueue.removeFirst();
        if (!nodeQueue.isEmpty())
            right = nodeQueue.removeFirst();
        
        root.left = left;
        root.right = right;
        deserializeHelper(nodeQueue, left);
        deserializeHelper(nodeQueue, right);
    }
    
    private LinkedList<TreeNode> parse(String data) {
        LinkedList<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        data = data.replace("[", "");
        data = data.replace("]", "");
        
        if ((data = data.trim()).equals("")) 
            return null;
        
        String[] dataArr = data.split(",");
        for (String ele: dataArr) {
            ele = ele.trim();
            if (ele.equals("null"))
                nodeQueue.add(null);
            else {
                TreeNode node = new TreeNode(Integer.parseInt(ele.trim()));
                nodeQueue.add(node);
            }
        }
        
        return nodeQueue;
    }
}
