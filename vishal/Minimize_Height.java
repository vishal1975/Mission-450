package vishal;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

import vishal.Kadanes_Algorithm.InputReader;

public class Minimize_Height {
	
	static int lower=Integer.MAX_VALUE;
	
	public static void find(int a[],int n) {
		
		int difference=0;
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			
			if(a[i]>max) {
				max=a[i];
			}
			if(a[i]<min) {
				min=a[i];
			}
			
		}
		
		difference=max-min;
		if(difference<lower) {
			lower=difference;
		}
		System.out.println(difference);
	}
	
	public static void array_find(int a[],int b[],int c[],int i,int n) {
		
		if(i>=n) {
			find(c,n);
			return ;
		}
		c[i]=a[i];
		array_find(a,b,c,i+1,n);
		c[i]=b[i];
		array_find(a,b,c,i+1,n);
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		InputReader in=new InputReader(System.in);    
//        StringBuffer str=new StringBuffer();
//		int t=in.nextInt();
//		for(int i=0;i<t;i++) {
//			int n=in.nextInt();
//			int a[]=new int[n];
//			for(int j=0;j<n;j++) {
//				a[j]=in.nextInt();
//			}
//		}
//		
		
		
		
		int a[]= {3,9,12,16,20};
		int b[]=new int[5];
		int c[]=new int[5];
		int d[]=new int[5];
		for(int i=0;i<5;i++) {
			b[i]=a[i]+3;
		}

		for(int i=0;i<5;i++) {
			c[i]=a[i]-3;
		}
		array_find(b,c,d,0,5);
		
		System.out.println("this is"+lower);
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
