package vishal;
// basic implementation of graph
import java.util.*;
public class Basic_Implementation {
	
	LinkedList<Integer> adj[];
	
	
	public void graph(int v) {
		adj=new LinkedList[v];
		
		for(int i=0;i<v;i++) {
			adj[i]=new LinkedList<Integer>();
		}
		
		
	}
	
	
	// undirected
	public void addEdge_undirected(int source,int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}
	
	
	
	//Directed
	public void addEdge_directed(int source,int destination) {
		
		
		adj[source].add(destination);
		
		
	}
	public boolean detect_cycle_util(int node,boolean[] visited,int parent) {
		
		visited[node]=true;
		for(int neighbour: adj[node]) {
			if(!visited[neighbour]) {
				if(detect_cycle_util(neighbour,visited,node)) {
					return true;
				}
				
			}
			else if(neighbour!=parent) {
				return true;
			}
		}
		return false;
		
	}
	
	public boolean detect_cycle(int node) {
		boolean visible[]=new boolean[adj.length];
		visible[node]=true;
		return detect_cycle_util(1,visible,node);
	}
	
	
	public boolean dfsutil(int source,int destination,boolean visible[]) {
		if(source==destination) {
			return true;
		}
			
			for(int neighbour: adj[source]) {
				if(!visible[neighbour]) {
					visible[neighbour]=true;
					boolean connection=dfsutil(neighbour,destination,visible);
					if(connection) {
						return true;
				}
			}
		}
		
		return false;
		
		
	}
	
	public boolean dfs(int source,int destination) {
		
		boolean visible[]=new boolean[adj.length];
		visible[source]=true;
		return dfsutil(source,destination,visible);
		
	}
	
	public boolean dfsStack(int source,int destination) {
		boolean visible[]=new boolean[adj.length];
		
		Stack<Integer> pk=new Stack<>();
		pk.add(source);
		visible[source]=true;
		while(!pk.isEmpty()) {
			int curr=pk.pop();
			if(curr==destination) {
				return true;
			}
			for(int neighbour:adj[curr]) {
				if(!visible[neighbour]) {
					visible[neighbour]=true;
					pk.add(neighbour);
				}
			}
		}
		
		return false;
	}
	
	
	public void bfs(int source,int destination) {
		
		boolean visited[]=new boolean[adj.length];
		int parent[]=new int[adj.length];
		
		Queue<Integer> traverse=new LinkedList<Integer>();
		traverse.add(source);
		visited[source]=true;
		parent[source]=-1;
		while(!traverse.isEmpty()) {
			int curr=traverse.poll();
			if(curr==destination) {
				
				break;
			}
			
			for(int neighbour: adj[curr]) {
				if(!visited[neighbour]) {
					visited[neighbour]=true;
					parent[neighbour]=curr;
					traverse.add(neighbour);
				}
			}
			
			
		}
		
		
		System.out.println("Shortest Distance");
		int i=destination;
		System.out.print(i+" => ");
		while(i!=source) {
			System.out.print(parent[i]+" => ");
			i=parent[i];
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Topological Sorting
	
	
	
	public void topoutil(int v,Stack<Integer> store,boolean visited[]) {
		
		
		for(int neighbour:adj[v]) {
			
			if(!visited[neighbour]) {
				
				visited[neighbour]=true;
				topoutil(neighbour, store,visited);
				
			}
			
			
			
		}
		
		store.add(v);
		
		
		
	}
	
	
	
	
	
	
	
	public  void topological_Sorting() {
		
		Stack<Integer> store=new Stack<Integer>();
		
		boolean visited[]=new boolean[adj.length];
		
		for(int i=0;i<adj.length;i++) {
			if(!visited[i]) {
				visited[i]=true;
				topoutil(i,store,visited);
				
			}
			
		}
		
		
		while(!store.isEmpty()) {
			
			System.out.print(store.pop()+" ");
			
		}
		
		
	}
	
	
	

	// detect cycle in directed graph
	
	public boolean detect_cycle_directed_util(int v,boolean visited[], boolean curr_visited[]) {
		
		visited[v]=true;
		curr_visited[v]=true;
		
		
		for(int neighbour:adj[v]) {
			
			if(curr_visited[neighbour]) {
				return true;
			}
			else if(!visited[neighbour]&&detect_cycle_directed_util(neighbour,visited,curr_visited)) {
				return true;
			}
			
		}
		
		curr_visited[v]=false;
		
		return false;
		
	}
	
	
	
	public boolean detect_cycle_directed() {
		
		
		boolean visited[]=new boolean[adj.length];
		boolean curr_visited[]=new boolean[adj.length];
		
		for(int i=0;i<adj.length;i++) {
			if(!visited[i]) {
				if(detect_cycle_directed_util(i,visited,curr_visited)) {
					return true;
				}
				
			}
		}
		
		return false;
		
	}
	
	public int min(int key[],boolean check[],int V) {
		int min=0;
		int min_value=Integer.MAX_VALUE;
		for(int i=1;i<V;i++) {
			if(!check[i]&&key[i]<min_value) {
				min_value=key[i];
				min=i;
			}
		}
		
		return min;
	}
	
	
	 public int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph) {
		 int total=0;
		 
		 int key[]=new int[V];
		 boolean check[]=new boolean[V];
		 for(int i=0;i<V;i++) {
			 check[i]=false;
			 key[i]=Integer.MAX_VALUE;
		 }
		 key[1]=0;
		 
		 for(int i=1;i<V;i++) {
			 
			 int u=min(key,check,V);
			 check[u]=true;
			 total=total+key[u];
			 
			 for(int j=0;j<graph.get(u).size();j++) {
				 if(graph.get(u).get(j)!=0&&!check[j]&&graph.get(u).get(j)<key[j])
					 key[j]=graph.get(u).get(j);
			 }
			 
		 }
		 
		 
		 return total;
	 }
	
	
	
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Basic_Implementation pk=new Basic_Implementation();
		
		
		int vertices;
		int edges;
		System.out.println("Enter vertices and edges");
		vertices=sc.nextInt();
		pk.graph(vertices);
		
		edges=sc.nextInt();
		System.out.println("enter source  and destination");
		
		for(int i=0;i<edges;i++) {
			int source=sc.nextInt();
			int destination=sc.nextInt();
			//pk.addEdge_undirected(source, destination);
			pk.addEdge_directed(source, destination);
		}
		//pk.bfs(0,3);
//		System.out.println(pk.detect_cycle(0));
		
		//pk.topological_Sorting();
		
		System.out.println(pk.detect_cycle_directed());
	}

}
