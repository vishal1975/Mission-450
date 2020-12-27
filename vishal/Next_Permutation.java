package vishal;
import java.util.*;
public class Next_Permutation {

	
public static void swap(int nums[],int i,int j){
        
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        
    }
	
	
	 public static void reverse(int nums[],int i){
	        
	        int mid=(nums.length-i)/2;
	          int j=nums.length-1;
	        for(int h=0;h<mid;h++){
	            swap(nums,h+i,j);
	            j--;
	        }
	    }
	 public static int binary_search(int nums[],int i,int j,int k,int h) {
		 int mid=(i+j)/2;
		 
		 if(i>j) {
			 return h;
		 }
		 else if(nums[mid]>=k) {
			 h=mid;
			 return binary_search(nums,mid+1,j,k,h);
		 }
		 else {
			 return binary_search(nums,i,mid-1,k,h);
		 }
		 
		 
	 }
	
	
	public static void nextPermutation(int[] nums) {
        int flag=0;
        
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
            	int h=binary_search(nums,i,nums.length-1,nums[i-1],i);
            	System.out.println(h);
                swap(nums,h,i-1);
                reverse(nums,i);
                flag=1;
                break;
            }
        }
        
        if(flag==0){
            Arrays.sort(nums);
        }
        
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++) {
			int n=sc.nextInt();
			int a[]=new int[n];
			for(int j=0;j<n;j++) {
				a[j]=sc.nextInt();
			}
			
		nextPermutation(a);
		System.out.println();
		}

	}

}
