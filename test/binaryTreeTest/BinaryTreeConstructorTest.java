package binaryTreeTest;

import static org.junit.Assert.*;
import org.junit.Test;

import binaryTree.*;

public class BinaryTreeConstructorTest {
	
	@Test
	public void testEmptyTree() {
		Integer[] treeList = new Integer[] {};
		TreeNode root = BinaryTreeConstructor.construct(treeList);
		assert(root == null);
	}
	
	@Test
	public void test2Nodes() {
		Integer[] treeList = new Integer[] {1,2};
		TreeNode rootAuto = BinaryTreeConstructor.construct(treeList);
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		assert(root.equals(rootAuto));
	}
	
	@Test
	public void testEmptyNodesShort() {
		Integer[] treeList = new Integer[] {1, 2, 3, 3, null, null, 3, 4};
		TreeNode rootAuto = BinaryTreeConstructor.construct(treeList);
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(3);
		
		root.left.left.left = new TreeNode(4);
		
		assert(root.equals(rootAuto));
	}
	
	@Test
	public void testEmptyNodesLong() {
		Integer[] treeList = new Integer[] {1, 2, 3, 3, null, null, 3, 4, null, null, null, null, null, null, null, 4};
		TreeNode rootAuto = BinaryTreeConstructor.construct(treeList);
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(3);
		
		root.left.left.left = new TreeNode(4);
		root.left.left.left.left = new TreeNode(4);
		
		assert(root.equals(rootAuto)); 
	}

}
