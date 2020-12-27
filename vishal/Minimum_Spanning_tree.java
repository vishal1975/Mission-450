package basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Minimum_Spanning_tree {
	
	int parent[];
	Edge edges[];
	int rank[];
	int v;
	int e;
	Minimum_Spanning_tree(int v,int e){
		this.v=v;
		
		this.e=e;
		
		parent=new int[v];
		for(int i=0;i<v;i++) {
			parent[i]=i;
		}
		edges=new Edge[e];
		rank=new int[v];
		
	}
	public void add_edge(int source,int destination,int weight,int i) {
		edges[i]=new Edge(source,destination,weight);
		
	}
	
	public int find(int s) {
		if(parent[s]==s) {
			return s;
		}
		parent[s]=find(parent[s]);
		return parent[s];
	}
	
	public void union(int x,int y) {
		
		
		parent[y]=x;
		
	}
	
	
	public int kruskal() {
		
		int total=0;
		Arrays.sort(edges,new Edge());
		
		for(Edge t: edges) {
			
			int x=find(t.source);
			int y=find(t.destination);
			if(x!=y) {
				total=total+t.weight;
				
				if(rank[x]==rank[y]) {
					union(x,y);
					rank[x]=rank[x]+1;
					
				}
				else if(rank[x]>rank[y]) {
					union(x,y);
				}
				else {
					union(y,x);
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
		
		
		
		
		System.out.println("enter no of edges");
		int edge=sc.nextInt();
		Minimum_Spanning_tree minimum=new Minimum_Spanning_tree(v,edge);
		System.out.println("Enter source , destination and weight");
		for(int i=0;i<edge;i++) {
			int source=sc.nextInt();
			int destination=sc.nextInt();
			int weight=sc.nextInt();
			minimum.add_edge(source,destination,weight,i);
			
		}
		
		int minimum_dis=minimum.kruskal();
		System.out.println(minimum_dis);
		

	}
	
	class Edge implements Comparator<Edge>{
		
		int source;
		int destination;
		int weight;
		Edge(){
			
		}
		Edge(int source,int destination,int weight){
			this.source=source;
			this.destination=destination;
			this.weight=weight;
		}
		@Override
		public int compare(Edge o1, Edge o2) {
			// TODO Auto-generated method stub
			
			
			
			return o1.weight-o2.weight;
		}
		
	}

}
