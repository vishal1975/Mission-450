package vishal;

import java.util.HashSet;
import java.util.Scanner;

public class Travelling_Salesman_Bitmask {
	
	
	public static int travelling(int graph[][],int mask,int pos,int n,int dp[][]) {
		
		if(mask==((1<<n)-1)) {
			return graph[pos][0];
		}
		
		if(dp[mask][pos]!=-1) {
			return dp[mask][pos];
		}
				
		int min=Integer.MAX_VALUE;
		
		for(int h=0;h<n;h++) {
			if((mask&(1<<h))==0) {
				
				int count=graph[pos][h]+travelling(graph,mask|(1<<h),h,n);
				if(count<min) {
					min=count;
				}
				
			}
		}
		
		return dp[mask][pos]=min;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		
//		int graph[][]= {{0,1000,5000},{5000,0,1000},{1000,5000,0}};
//		int min_distance=travelling(graph,1,0,graph[0].length);
//		System.out.println(min_distance);
//		
		
		
		
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
			
			int dp[][]=new int[(int) Math.pow(2,n)][n];
			
			for(int h=0;h<(1<<n);h++) {
				
				for(int k=0;k<n;k++) {
					dp[h][k]=-1;
				}
			}
			
			
		int z=travelling(graph,1,0,n,dp);
		System.out.println(z);
		
	}
		
		
		
		
		
		
		
		
	}

}
