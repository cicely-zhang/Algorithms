package linear;

import java.util.*;

public class MergeList {
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		ListNode dummyHead = new ListNode(0);
        ListNode lastNode = dummyHead;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            }
            else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }
        
        if (l1 != null)
            lastNode.next = l1;
        else if (l2 != null)
            lastNode.next = l2;
            
        return dummyHead.next;
	}
	
	public static ListNode mergeKSortedList(ListNode[] sortedLists) {
		
		Comparator<ListNode> listNodeComparator = new Comparator<ListNode>() {
			public int compare(ListNode node1, ListNode node2) {
				if (node1 == null)
					return -1;
				else if (node2 == null)
					return 1;
				return node1.val - node2.val;
			} 
		};
	    
		Queue<ListNode> minHeap = new PriorityQueue<ListNode>(listNodeComparator);
		ListNode dummyHead = new ListNode(0);
		ListNode lastNode = dummyHead;
		
		for (ListNode node: sortedLists) {
			if (node != null)
				minHeap.add(node);
		}
		
		while (!minHeap.isEmpty()) {
			ListNode minNode = minHeap.poll();
			lastNode.next = minNode;
			if (minNode.next != null)
				minHeap.add(minNode.next);
			lastNode = lastNode.next;
		}
		
		return dummyHead.next;
		
	}
}
