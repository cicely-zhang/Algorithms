package graph;
import java.util.*;

public class CloneGraph {
	
	class Node {
		int id;
		ArrayList<Node> neighbors;
		
		public Node (int id) {
			this.id = id;
			neighbors = new ArrayList<Node>();
		}
	}
	
	public Node clone(Node node) {
		
		if (node == null)
			return null;
		
		HashMap<Node, Node> visited = new HashMap<Node, Node>();
		return cloneHelper(node, visited);
	}
	
	//Used DFS traversal
	private Node cloneHelper(Node node, HashMap<Node, Node> visitedMap) {
		Node cloned = new Node(node.id);
		visitedMap.put(node, cloned);
		for(Node neighbor: node.neighbors) {
			if (!visitedMap.containsKey(neighbor)) {
				Node clonedNeighbor = this.cloneHelper(neighbor, visitedMap);
				cloned.neighbors.add(clonedNeighbor);
			}
			else {
				cloned.neighbors.add(visitedMap.get(neighbor));
			}
		}
		return cloned;
	}
	
	//Print out the graph in BFS traversal
	public Node cloneInBFS(Node node) {
		if (node == null) {
			  return null;
		  }
		  HashMap<Node, Node> visited = new HashMap<Node, Node>();
		  LinkedList<Node> processing = new LinkedList<Node>();
		  processing.add(node);
		  visited.put(node, new Node(node.id));
		  
		  while (!processing.isEmpty()) {
			  Node curNode = processing.removeFirst();
			  Node clonedCurNode = visited.get(curNode);
			  
			  for(Node neighbor: curNode.neighbors) {
				  if (!visited.containsKey(neighbor)) {
					  processing.addLast(neighbor);
					  visited.put(neighbor, new Node(neighbor.id));
				  }
				  clonedCurNode.neighbors.add(visited.get(neighbor));
			  }
		  }
		  
		  return visited.get(node);
		  
	}
	
	public void printInBFS(Node node) {
		if (node == null) {
			System.out.print("This is an empty tree");
		}
		
		HashSet<Node> visited = new HashSet<Node>();
		LinkedList<Node> processing = new LinkedList<Node>();
		visited.add(node);
		processing.add(node);
		
		while (!processing.isEmpty()) {
			Node curNode = processing.removeFirst();
			System.out.print(curNode.id);
			
			for(Node neighbor: curNode.neighbors) {
				if (!visited.contains(neighbor)) {
					visited.add(neighbor);
					processing.addLast(neighbor);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner("input.txt");
		int totalNodes = inputScanner.nextInt();
		for (int i = 0; i < totalNodes; i ++) {
			String line = inputScanner.next();
			String[] eles = line.split(" ");
			Node node = new Node(i);
			for(String ele : eles) {
				
			}
		}
	}

}
