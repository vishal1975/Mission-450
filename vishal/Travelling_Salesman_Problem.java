package basic;
import java.util.*;
public class Travelling_Salesman_Problem {
	
	
	public static int travelling_salesman_util(int graph[][],boolean visited[],Set<Integer> pk,int i,int j,int v,int source) {
	
		visited[j]=true;
		pk.add(j);
		if(pk.size()==v) {
			visited[j]=false;
			pk.remove(j);
			return graph[j][source];
		}
		int min=Integer.MAX_VALUE;
		int count=0;
		
		for(int h=0;h<graph[j].length;h++) {
			if(h!=j&&!visited[h]) {
				count=graph[j][h]+travelling_salesman_util(graph,visited,pk,j,h,v,source);
				if(count<min) {
					min=count;
				}
			}
		}
		visited[j]=false;
		pk.remove(j);
		return min;
		
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++) {
			int n=sc.nextInt();
			int graph[][]=new int[n][n];
			
			for(int p=0;p<n;p++) {
				for(int q=0;q<n;q++) {
					graph[p][q]=sc.nextInt();
				}
			}

//		int graph[][]= {{0,1000,5000},{5000,0,1000},{1000,5000,0}};
	//	int graph[][]= {{0,10,15,20},{10,0,35,25},{15,35,0,30},{20,25,30,0}};
		//boolean visited[][]=new boolean[3][3];
		boolean visited[]=new boolean[n];
		int z=travelling_salesman_util(graph,visited,new HashSet<>(),0,0,n,0);
		System.out.println(z);
	}
	}

}
