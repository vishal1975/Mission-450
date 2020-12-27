package vishal;
import java.util.*;
public class K_Largest {

	 public static int[] kLargest(int[] arr, int n, int k) {
	        // code here
		 
		 PriorityQueue<Integer> pk=new  PriorityQueue<Integer>();
		 for(int i=0;i<k;i++) {
			 pk.add(arr[i]);
		 }
		 
		 for(int i=k;i<n;i++) {
			 if(arr[i]>pk.peek()) {
				 pk.remove();
				 pk.add(arr[i]);
			 }
		 }
		 int b[]=new int[pk.size()];
		 int h=0;
		 for(h=pk.size()-1;h>=0;h--) {
			 b[h]=pk.remove();
		 }
		 return b;
		 
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
