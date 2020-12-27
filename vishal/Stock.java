package vishal;

public class Stock {
	
	static int max=Integer.MIN_VALUE;
	
	public static void merge(int a[],int i,int j,int mid) {
		int h=i;
		int k=mid+1;
		int b[]=new int[j-i+1];
		int p=0;
		int count=a[j]-a[i];
		if(count>max) {
			max=count;
		}
		while(h<=mid&&k<=j) {
			if(a[h]<=a[k]) {
				b[p++]=a[h];
				h++;
				
			}
			if(a[k]<a[h]) {
				b[p++]=a[k];
				k++;
				//inversion_count+=mid-h+1;
			}
		}
		while(h<=mid) {
			
			b[p++]=a[h];
			h++;
			
		}
		while(k<=j) {
			b[p++]=a[k];
			k++;
		}
		p=0;
		for(h=i;h<=j;h++) {
			a[h]=b[p++];
		}
		
	}
	
	
	
	public static void mergesort(int a[],int i,int j) {
	if(i>=j) {
		return ;
	}
	
	int mid=(i+j)/2;
	int count=0;
	mergesort(a,i,mid);
	mergesort(a,mid+1,j);
	merge(a,i,j,mid);
		
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[]= {7,6,4,3,1};
		mergesort(a,0,a.length-1);
		if(max<0) {
			System.out.println(0);
		}
		else
		System.out.println(max);

	}

}
