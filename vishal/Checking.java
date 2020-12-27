package basic;
import java.util.*;

public class Checking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> pk=new PriorityQueue<>(6,new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				
				return 0;
			}
			
		});

	}

}
class Node{
	
	int node;
	int cost;
	Node(int node,int cost){
		this.node=node;
		this.cost=cost;
	}
	
	
}
