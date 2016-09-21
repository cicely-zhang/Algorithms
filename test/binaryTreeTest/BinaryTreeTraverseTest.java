package binaryTreeTest;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.Test;
import binaryTree.*;

public class BinaryTreeTraverseTest {
	
	@Test
	public void testLevelOrderTraverse0Node() {
		
		List<List<Integer>> retList = BinaryTreeTraverse.levelOrderTraverse(null);
		List<List<Integer>> genList = new ArrayList<List<Integer>>();
		assert(genList.equals(retList));
	}
	
	@Test
	public void testLevelOrderTraverse1Node() {
		
		List<List<Integer>> retList = BinaryTreeTraverse.levelOrderTraverse(new TreeNode(1));
		List<List<Integer>> genList = new ArrayList<List<Integer>>();
		genList.add(Arrays.asList(1));
		assert(genList.equals(retList));
	}

	@Test
	public void testLevelOrderTraverse() {
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		
		node.right.left = new TreeNode(4);
		node.right.right = new TreeNode(5);
		
		List<List<Integer>> retList = BinaryTreeTraverse.levelOrderTraverse(node);
		
		List<List<Integer>> genList = new ArrayList<List<Integer>>();
		List<Integer> firstLine = Arrays.asList(1);
		List<Integer> secondLine = Arrays.asList(2,3);
		List<Integer> thirdLine = Arrays.asList(4,5);
		
		genList.add(firstLine);
		genList.add(secondLine);
		genList.add(thirdLine);
		
		assert(genList.equals(retList));
	}

}
