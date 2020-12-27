package vishal;
import java.util.*;
public class Pairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int count=0;
            int a[]=new int[n];
            HashMap<Integer,Integer> pk=new HashMap<Integer,Integer>();
            for(int j=0;j<n;j++) {
            	a[j]=sc.nextInt();
            	
            	if(pk.containsKey(a[j])) {
    				pk.put(a[j],pk.get(a[j])+1);
    			}
    			else {
    				pk.put(a[j],1);
    			}
            }
		
		
		for(int j=0;j<n;j++) {
			
			if(k-a[j]>=0) {
				if(pk.containsKey(k-a[j])) {
					
					if(k-a[j]==a[j]) {
						
						count=count+pk.get(k-a[j])-1;
						pk.replace(a[j], pk.get(a[j])-1);
					}
					else {
						//System.out.println(pk.get(k-a[j]));
						count=count+pk.get(k-a[j]);
						pk.replace(a[j], pk.get(a[j])-1);
					}
				}
			}
		}
		System.out.println(count);
		
		
	}

}
