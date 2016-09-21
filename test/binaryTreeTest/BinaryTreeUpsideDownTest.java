package binaryTreeTest;

import static org.junit.Assert.*;

import org.junit.Test;
import binaryTree.*;

public class BinaryTreeUpsideDownTest {
	
	@Test
	public void testNoNodes() {
		TreeNode flipped = BinaryUpsideDown.flipUpsideDown(null);
		assert(flipped == null);
	}
	
	@Test
	public void test1Node() {
		TreeNode flipped = BinaryUpsideDown.flipUpsideDown(new TreeNode(1));
		assert(flipped.equals(new TreeNode(1)));
	}

	@Test
	public void test5Nodes() {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		
		TreeNode flipped = BinaryUpsideDown.flipUpsideDown(node);
		
		TreeNode flippedManual = new TreeNode(4);
		flippedManual.left = new TreeNode(5);
		flippedManual.right = new TreeNode(2);
		
		flippedManual.right.left = new TreeNode(3);
		flippedManual.right.right = new TreeNode(1);
		assert(flipped.equals(flippedManual));
	}

}
