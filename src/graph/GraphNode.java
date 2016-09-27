package graph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GraphNode {
	
	int id;
	ArrayList<GraphNode> neighbors;
	
	public GraphNode (int id) {
		this.id = id;
		neighbors = new ArrayList<GraphNode>();
	}
	
	public GraphNode clone(GraphNode node) {
		
		if (node == null)
			return null;
		
		HashMap<GraphNode, GraphNode> visited = new HashMap<GraphNode, GraphNode>();
		return cloneHelper(node, visited);
	}
	
	//Used DFS traversal
	private GraphNode cloneHelper(GraphNode node, HashMap<GraphNode, GraphNode> visitedMap) {
		GraphNode cloned = new GraphNode(node.id);
		visitedMap.put(node, cloned);
		for(GraphNode neighbor: node.neighbors) {
			if (!visitedMap.containsKey(neighbor)) {
				GraphNode clonedNeighbor = this.cloneHelper(neighbor, visitedMap);
				cloned.neighbors.add(clonedNeighbor);
			}
			else {
				cloned.neighbors.add(visitedMap.get(neighbor));
			}
		}
		return cloned;
	}
	
	//Print out the graph in BFS traversal
	public GraphNode cloneInBFS() {

		  HashMap<GraphNode, GraphNode> visited = new HashMap<GraphNode, GraphNode>();
		  LinkedList<GraphNode> processing = new LinkedList<GraphNode>();
		  processing.add(this);
		  visited.put(this, new GraphNode(this.id));
		  
		  while (!processing.isEmpty()) {
			  GraphNode curNode = processing.removeFirst();
			  GraphNode clonedCurNode = visited.get(curNode);
			  
			  for(GraphNode neighbor: curNode.neighbors) {
				  if (!visited.containsKey(neighbor)) {
					  processing.addLast(neighbor);
					  visited.put(neighbor, new GraphNode(neighbor.id));
				  }
				  clonedCurNode.neighbors.add(visited.get(neighbor));
			  }
		  }
		  
		  return visited.get(this);
		  
	}
	
	public static void printInBFS(GraphNode node) {
		if (node == null) {
			System.out.print("This is an empty tree");
		}
		
		HashSet<GraphNode> visited = new HashSet<GraphNode>();
		LinkedList<GraphNode> processing = new LinkedList<GraphNode>();
		visited.add(node);
		processing.add(node);
		
		while (!processing.isEmpty()) {
			GraphNode curNode = processing.removeFirst();
			System.out.print(curNode.id + " ");
			
			for(GraphNode neighbor: curNode.neighbors) {
				if (!visited.contains(neighbor)) {
					visited.add(neighbor);
					processing.addLast(neighbor);
				}
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner inputScanner = new Scanner(new File("C:\\MyStuff\\JavaRepo\\Algorithms\\src\\graph\\CloneGraphInput.txt"));
		int totalNodes = inputScanner.nextInt();
		HashMap<Integer, GraphNode> createdList = new HashMap<Integer, GraphNode>();
		Integer nodeId = 0;
		while (true) {
			String line = inputScanner.nextLine();
			
			if (line.trim().isEmpty())
				continue;
			
			if (line.trim().equals("-1"))
				break;
			
			String[] eles = line.split(" ");
			Integer numOfNeighbors = Integer.parseInt(eles[0].trim());
			
			if (!createdList.containsKey(nodeId))
				createdList.put(nodeId, new GraphNode(nodeId));
			
			GraphNode node = createdList.get(nodeId);
			for(int j = 1; j < numOfNeighbors + 1; j ++) {
				int neighborNodeId = Integer.parseInt(eles[j].trim());
				if (!createdList.containsKey(neighborNodeId))
					createdList.put(neighborNodeId, new GraphNode(neighborNodeId));
				
				GraphNode neighborNode = createdList.get(neighborNodeId);
				node.neighbors.add(neighborNode);
			}
			nodeId ++;
		}
		
		GraphNode cloned = createdList.get(0).cloneInBFS();
		GraphNode.printInBFS(cloned);
		
	}

}
