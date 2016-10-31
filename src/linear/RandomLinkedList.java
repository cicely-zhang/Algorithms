package linear;

import java.util.*;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};
    
public class RandomLinkedList {
	
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
            
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode current = head;
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode newCurrent = dummyHead;
        while (current != null) {
            if (!map.containsKey(current)) {
                RandomListNode node = new RandomListNode(current.label);
                map.put(current, node);
                newCurrent.next = node;
            }
            else {
                newCurrent.next = map.get(current);
            }
            
            if (current.random != null && !map.containsKey(current.random)) {
                RandomListNode node1 = new RandomListNode(current.random.label);
                map.put(current.random, node1);
                newCurrent.next.random = node1;
            }
            else if (current.random != null && map.containsKey(current.random)) {
            	newCurrent.next.random = map.get(current.random);
            }
            current = current.next;
            newCurrent = newCurrent.next;
        }
        return dummyHead.next;
    }
	
	public static void main(String[] args) {
		RandomLinkedList list = new RandomLinkedList();
		RandomListNode head = new RandomListNode(-1);
		RandomListNode next = new RandomListNode(-1);
		next.random = head;
		head.next = next;
		RandomListNode newHead = list.copyRandomList(head);
	}
}
