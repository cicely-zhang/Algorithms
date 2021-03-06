package binaryTreeTest;

import static org.junit.Assert.*;

import org.junit.Test;
import binaryTree.*;

public class BinaryTreeSerializerTest {

	@Test
	public void testSerializer() {
		String data = "[1,-1,2,null,null,3]";
		BinaryTreeSerializer serializer = new BinaryTreeSerializer();
		TreeNode node = serializer.deserialize(data);
		assert (serializer.serialize(node).equals("[1, -1, 2, null, null, 3]"));
	}
	
	@Test
	public void testSerializerMore() {
		String data = "[5,2,3,null,null,2,4,3,1]";
		BinaryTreeSerializer serializer = new BinaryTreeSerializer();
		TreeNode node = serializer.deserialize(data);
		assert (serializer.serialize(node).equals("[5, 2, 3, null, null, 2, 4, 3, 1]"));
	}

}
