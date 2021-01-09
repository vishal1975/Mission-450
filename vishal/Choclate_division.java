package vishal;

public class Choclate_division {
	
	public static int division(int a,int b) {
		
		if(a==b) {
			return 1;
		}
		
		if(a==1) {
			return b;
		}
		if(b==1) {
			return a;
		}
		
		int c=Math.min(a, b);
		int d=Math.max(a, b);
		int count=d/c;
		int t=d/c;
		count=count+division(d-c*t,c);
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t=division(4,4);
		System.out.println(t);
	}

}
