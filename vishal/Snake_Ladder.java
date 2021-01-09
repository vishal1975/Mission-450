package vishal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Snake_Ladder {
	static File myObj = new File("E:/filename1.txt");
	
	 public static int snakesAndLadders(int[][] board) {
	     
	     //boolean visited[][]=new boolean[board.length][board[0].length]
	       int n=board.length;
	       boolean visited[]=new boolean[n*n+1];
	      
	       int dp[]=new int[n*n+1];
	       for(int i=0;i<=n*n;i++) {
	    	   dp[i]=-1;
	       }
	       visited[1]=true;
	       int t=snakesAndLadders_util(board,visited,1,n,dp,0);
//	       for(int i=0;i<=n*n;i++) {
//	    	   System.out.print(dp[i]+" , ");
//	       }
//	       System.out.println();
//	       for(int i=0;i<=n*n;i++) {
//	    	   System.out.print(visited[i]+"  ");
//	       }
	       if(t<=n*n){
	           return t;
	       }
	      
	       
	       
	      // return t;
	      
	       return -1;
	       
	    }

	 public static int snakesAndLadders_util(int[][] board,boolean visited[],int p,int n,int dp[],int v){
	//print(p,visited);
	     
	      if (p==n*n){
	     
	    	dp[p]=0;
	        return 0;
	      }
	      
	    

	      
	      if(dp[p]!=-1) {
	 
	    	  
	    	  return dp[p];
	     
	      }
	      //visited[p]=true;
	        int i=0;
	        int j=0;
	        

	            int min=n*n+1;
	            int count=0;    

	     
	        
	      for(int h=1;h<=6;h++){
	          if((p+h)<=n*n){
	        	  int z=p+h;
	        	  if(!visited[z]) {
	        		  visited[z]=true;  
	        	  int arr[]=pos(z,n);
	        	  i=arr[0];
	  	          j=arr[1];
	  	          if(board[i][j]!=-1) {
	  	        	  int t=board[i][j];
	  	        	 count=1+snakesAndLadders_util(board,visited,t,n,dp,z);
	  	          }
	  	          else {
	  	        	 count=1+snakesAndLadders_util(board,visited,z,n,dp,0);
	  	          }
	  	          
	  	        	
	         
	          
	              if(count<min){
	                  min=count;
	              }
	  	          }
	          }
	      }
	      visited[p]=false;
	      if(v==0) {
	    visited[p]=false;
	      }
	      else {
	    	  System.out.println(v);
	    	 // visited[v]=false;
	      }
	  
	    if(dp[p]==-1) {
	      dp[p]=min;
	    }
	    else if(dp[p]!=-1) {
	    	
	    	dp[p]=Math.min(dp[p],min);
	    }
	        return dp[p];
	     
	     
	    }
	 
	 public static void again(boolean visited[],int p) {
	       for(int i=p;i<visited.length;i++) {
	    	   visited[i]=false;
	       }

	 }
	 
	 public static void print(int p,boolean visited[]) {
		 
		 
		 try {
			 BufferedWriter out = new BufferedWriter(new FileWriter(myObj.getAbsoluteFile()));
			 //out.write(" "+p);
		      for(int i=0;i<visited.length;i++) {
		    	  out.write(" "+visited[i]+","+p);
		       }
		      out.newLine();
		      
		     out.close();
		   //   System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		 
		 
	 }
	 
	 public static int[] pos(int p,int n) {
		 
//		 int arr[]=new int[2];
//		 
//		 
//		 int i=0;
//	        int j=0;
//	         //i=n-p/n-1;
//	       if(n%2==0) {
//	       if(p%n==0){
//	           i=n-p/n;
//	            if(i%2==0){
//	                j=0;
//	            }  
//	           else{
//	               j=n-1;
//	           }
//	           
//	       }
//	        else{  
//	           
//	            i=n-p/n-1;
//	            if(i%2==0){
//	                j=n-p%n;
//	            }
//	            else{
//	                j=p%n-1;
//	            }
//	    }
//	       }
//	       
//	       
//	       
//	       else {
//	    	   
//	    	   
//	    	   
//	    	   if(p%n==0){
//		           i=n-p/n;
//		            if(i%2==0){
//		            	 j=n-1;
//		            }  
//		           else{
//		               j=0;
//		           }
//		           
//		       }
//	    	   
//	    	   
//	    	   
//	    	   
//	    	   
//	    	   else{  
//		           
//		            i=n-p/n-1;
//		            if(i%2==0){
//		                
//		                j=p%n-1;
//		            }
//		            else{
//		            	j=n-p%n;
//		            }
//		    }
//	    	   
//	    	   
//	    	   
//	    	   
//	    	   
//	    	   
//	    	   
//	       }
	       
	       
	       
	       
	       int r=n-(p-1)/n -1;
	       int c=(p-1)%n;
	       if(r%2==n%2) {
	    	   return new int[] {r,n-1-c};
	       }
	       else {
	    	   return new int[] {r,c};
	       }
	       
	       
	       
	       
	       
	       
	       
	       
		 
//		 arr[0]=i;
//		 arr[1]=j;
//		 
//		// System.out.print(i+" , "+j);
//		// System.out.println();
//		 return arr;
		 
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int board[][]= {
//{-1,-1,-1,-1,-1,-1},
//{-1,-1,-1,-1,-1,-1},
//{-1,-1,-1,-1,-1,-1},
//{-1,35,-1,-1,13,-1},
//{-1,-1,-1,-1,-1,-1},
//{-1,15,-1,-1,-1,-1}};
		
//		int board[][]= {{1,4},
//				        {-1,3
//			}
//		};
//		int board[][]= {{-1,-1,-1},
//		        {9,-1,-1},
//		        {-1,4,-1}};
		
		int board[][]= {{-1,83,-1,46,-1,-1,-1,-1,40,-1},
				{-1,29,-1,-1,-1,51,-1,18,-1,-1},
				{-1,35,31,51,-1,6,-1,40,-1,-1},
				{-1,-1,-1,28,-1,36,-1,-1,-1,-1},
				{-1,-1,-1,-1,44,-1,-1,84,-1,-1},
				{-1,-1,-1,31,-1,98,27,94,74,-1},
				{4,-1,-1,46,3,14,7,-1,84,67},
				{-1,-1,-1,-1,2,72,-1,-1,86,-1},
				{-1,32,-1,-1,-1,-1,-1,-1,-1,19},
				{-1,-1,-1,-1,-1,72,46,-1,92,6}};
	
		int y=snakesAndLadders(board);
		System.out.println(y);

	}

}
