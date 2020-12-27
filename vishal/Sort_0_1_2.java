package vishal;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

import vishal.Smallest_Kth_Element.InputReader;

public class Sort_0_1_2 {
	
	
	public static void swap(int a[],int i,int j) {
		int k=a[i];
		a[i]=a[j];
		a[j]=k;
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
			int h=0;
			int p=-1;
			for(int k=0;k<n;k++) {
				if(h==k&&a[k]==0) {
					h++;
				}
				else if(a[k]==2) {
					if(p==-1) {
						p=k;
					}
				}
				else if(a[k]==1&&h!=k) {
					if(a[h]==2) {
						swap(a,h,k);
						p++;
					}
					else {
					if(p>h&&p<k) {
						a[k]=2;
						a[p]=1;
						p++;
					}
					
					}
				}
				else if(a[k]==0) {
					System.out.println(k+" "+h);
					if(a[h]==2) {
						swap(a,h,k);
						p++;
						h++;
					}
					else {
						if(p>h&&p<k) {
							a[h]=a[k];
							a[k]=2;
							a[p]=1;
							p++;
							h++;
						}
						else {
							swap(a,h,k);
							h++;
						}
					}
					
				}
			}
			
			for(int j=0;j<n;j++) {
				System.out.print(a[j]+" ");
			}
			
			
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
