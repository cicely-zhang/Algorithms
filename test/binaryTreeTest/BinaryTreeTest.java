package binaryTreeTest;

import static org.junit.Assert.*;
import org.junit.Test;

import binaryTree.*;

public class BinaryTreeTest {
	
	@Test
	public void testEmptyTree() {
		Integer[] treeList = new Integer[] {};
		TreeNode root = BinaryTree.formTree(treeList);
		assert(root == null);
	}
	
	@Test
	public void test2Nodes() {
		Integer[] treeList = new Integer[] {1,2};
		TreeNode rootAuto = BinaryTree.formTree(treeList);
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		assert(root.equals(rootAuto));
	}
	
	@Test
	public void testEmptyNodesShort() {
		Integer[] treeList = new Integer[] {1, 2, 3, 3, null, null, 3, 4};
		TreeNode rootAuto = BinaryTree.formTree(treeList);
		
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
		TreeNode rootAuto = BinaryTree.formTree(treeList);
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(3);
		
		root.left.left.left = new TreeNode(4);
		root.left.left.left.left = new TreeNode(4);
		
		assert(root.equals(rootAuto)); 
	}
	
	@Test
	public void testNotValidBinarySearchTree() {
		
		BinaryTree tree = new BinaryTree(new Integer[] {3,1,5,null, null,2,6});
		assert(tree.isValidBinarySearchTreeV1()==false);
	}
	
	@Test
	public void testValidBinarySearchTree() {
		
		BinaryTree tree = new BinaryTree(new Integer[] {3,1,5,null, 2,null,6});
		assert(tree.isValidBinarySearchTreeV1()==true);
	}
}
