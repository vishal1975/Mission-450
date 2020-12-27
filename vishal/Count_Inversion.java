package vishal;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;



public class Count_Inversion {
	
	
	public static int merge(int a[],int i,int j,int mid) {
		int h=i;
		int k=mid+1;
		int b[]=new int[j-i+1];
		int p=0;
		int inversion_count=0;
		
		while(h<=mid&&k<=j) {
			if(a[h]<=a[k]) {
				b[p++]=a[h];
				h++;
				
			}
			if(a[k]<a[h]) {
				b[p++]=a[k];
				k++;
				inversion_count+=mid-h+1;
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
		return inversion_count;
	}
	
	
	
	public static int mergesort(int a[],int i,int j) {
	if(i>=j) {
		return 0;
	}
	
	int mid=(i+j)/2;
	int count=0;
	count=mergesort(a,i,mid);
	int count1=count+mergesort(a,mid+1,j);
	return count1+merge(a,i,j,mid);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		InputReader in=new InputReader(System.in);    
        StringBuffer str=new StringBuffer();
        int t=in.nextInt();
        for(int i=0;i<t;i++) {
        	int n=in.nextInt();
        	
        	int a[]=new int[n];
        	for(int j=0;j<n;j++) {
        		a[j]=in.nextInt();
        	}
        	
        int count=	mergesort(a,0,n-1);
        System.out.println(count);
//        	for(int j=0;j<n;j++) {
//        		System.out.print(a[j]+ " ");
//        	}
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
