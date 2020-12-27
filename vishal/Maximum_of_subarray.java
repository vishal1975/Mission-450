package vishal;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class Maximum_of_subarray {
	
	public static boolean check(HashMap<Integer,Integer> hh,int k) {
		if(hh.containsKey(k)) {
			return true;
		}
		return false;
	}
	
	public static void add(HashMap<Integer,Integer> hh,int k) {
		if(hh.containsKey(k)) {
			hh.put(k,hh.get(k)+1);
		}
		else {
			hh.put(k,1);
		}
	}
	public static void remove(HashMap<Integer,Integer> hh,int k) {
		if(hh.get(k)>1) {
			hh.replace(k,hh.get(k)-1);
		}
		else {
			hh.remove(k);
		}
	}
	
	public static void removeit(HashMap<Integer,Integer> hh,PriorityQueue<Integer> pk) {
		pk.remove();
		while(!check(hh,pk.peek())&&pk.peek()!=null) {
			pk.remove();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in=new InputReader(System.in);                     
        StringBuffer str=new StringBuffer();                             
        int t=in.nextInt();                                       
        for(int i=0;i<t;i++) {                                                                
        	int n=in.nextInt();
        	int k=in.nextInt();
        	int a[]=new int[n];
        	for(int j=0;j<n;j++) {
        		a[j]=in.nextInt();
        	}
		PriorityQueue<Integer> pk=new PriorityQueue<Integer>(k,Collections.reverseOrder());
		ArrayList<Integer> ll=new ArrayList<Integer>();
		HashMap<Integer,Integer> hh=new HashMap<Integer,Integer>();
		
		for(int j=0;j<k;j++) {
			pk.add(a[j]);
			add(hh,a[j]);
		}
		ll.add(pk.element());
		//System.out.println(pk.element());
		int h=0;
		for(int j=k;j<n;j++) {
			remove(hh,a[h]);
			if(!check(hh,pk.peek())) {
				removeit(hh,pk);
			}
			pk.add(a[j]);
			add(hh,a[j]);
			ll.add(pk.element());
			
			h++;
			
		}
		for(int j=0;j<ll.size();j++) {
			System.out.print(ll.get(j)+" ");
		}
		System.out.println();
		
        }

	}
	
	
	static class InputReader{
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
 
        public int read() {
            if (numChars == -1)
                throw new UnknownError();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
 
        public int peek() {
            if (numChars == -1)
                return -1;
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar];
        }
 
        public void skip(int x) {
            while (x-- > 0)
                read();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public long nextLong() {
            return Long.parseLong(next());
        }
 
        public String nextString() {
            return next();
        }
 
        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuffer res = new StringBuffer();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public String nextLine() {
            StringBuffer buf = new StringBuffer();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r')
                    buf.appendCodePoint(c);
                c = read();
            }
            return buf.toString();
        }
 
        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }
 
        public boolean hasNext() {
            int value;
            while (isSpaceChar(value = peek()) && value != -1)
                read();
            return value != -1;
        }
        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }


	

}
