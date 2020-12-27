package basic;
import java.util.*;
public class Shortest_Path {
	List<List<Node>> pk;
	int v;
	
	Shortest_Path(int v){
		this.v=v;
		pk=new ArrayList<>();
		for(int i=0;i<v;i++) {
			pk.add(new ArrayList<>());
		}
		
	}
	void initialize_list(int source,int destination,int weight) {
		pk.get(source).add(new Node(destination, weight));
		pk.get(destination).add(new Node(source, weight));
		
	}
	
	public void dijkstara(int source) {
		PriorityQueue<Node> min=new PriorityQueue<>(v,new Node());
		
	//	min.
		
		Set<Integer> unique=new HashSet<>();
		int distance[]=new int[v];
		int path[]=new int[v];
		path[source]=source;
		for(int i=0;i<v;i++) {
			distance[i]=Integer.MAX_VALUE;
		}
		distance[source]=0;
		min.add(new Node(source,0));
		
		while(unique.size()!=v) {
			Node temp=min.remove();
			int x=temp.node;
			unique.add(x);
			
			for(int z=0;z<pk.get(x).size();z++) {
				Node ll=pk.get(x).get(z);
				int dis=ll.cost;
				
				if(dis+distance[x]<distance[ll.node]) {
					distance[ll.node]=dis+distance[x];
					path[ll.node]=x;
					min.add(ll);
				}
				
			}
			
		}
		for(int i=0;i<distance.length;i++) {
			System.out.print(distance[i]+" ");
		}
		int from=5;
		int to=source;
		System.out.println();
		System.out.print(from+"-->");
		while(from!=to) {
			System.out.print(path[from]+"-->" );
			from=path[from];
		}
		
		
	}
	
	
	// Minimum spanning tree algorithm, this one is prim's algorithm
	
	public int prim_algo_minimum_spanning_tree() {
		
		int total=0;
		
		PriorityQueue<Node> min=new PriorityQueue<>(v,new Node());
		Set<Integer> unique=new HashSet<>();
		int distance[]=new int[v];
		
		for(int i=0;i<v;i++) {
			distance[i]=Integer.MAX_VALUE;
		}
		distance[0]=0;
		min.add(new Node(0,0));
		
		
		while(unique.size()!=v) {
			Node temp=min.remove();
			if(!unique.contains(temp.node)) {
				total=total+temp.cost;
			
			
			System.out.println(total);
			int x=temp.node;
			unique.add(x);
			
			for(int z=0;z<pk.get(x).size();z++) {
				Node ll=pk.get(x).get(z);
				int dis=ll.cost;
				if(!unique.contains(ll.node)) {
					
				if(dis<distance[ll.node]) {
					distance[ll.node]=dis;
					
					min.add(ll);
				}
				}
				
			}
			
		}
		}
		
		
		
		
		
		
		
		
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("eneter no of vertex");
		int v=sc.nextInt();
		
		Shortest_Path path=new Shortest_Path(v);
		
		
		System.out.println("enter no of edges");
		int edge=sc.nextInt();
		System.out.println("Enter source , destination and weight");
		for(int i=0;i<edge;i++) {
			int source=sc.nextInt();
			int destination=sc.nextInt();
			int weight=sc.nextInt();
			path.initialize_list(source, destination, weight);
		}
		
//		System.out.println("enter source");
//		int source=sc.nextInt();
//		path.dijkstara(source);
		
		
		System.out.println("lets find minimum spanning tree");
		System.out.println();
		
	int min_dis=path.prim_algo_minimum_spanning_tree();
	
	System.out.println(min_dis);

	}

}
class Node implements Comparator<Node>{
	
	int node;
	int cost;
	Node(){
		
	}
	
	Node(int node,int cost){
		this.node=node;
		this.cost=cost;
	}

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		if(o1.cost<o2.cost)
			return -1;
		else if(o1.cost>o2.cost)
			return 1;
		return 0;
	}
	
}
