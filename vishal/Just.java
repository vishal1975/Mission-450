package vishal;
import java.util.*;
public class Just {
	
	
	public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        
        queue.add(1); // Adding starting position to the Queue and marking that position to TRUE
        visited[n-1][0] = true;
        int step =0;
        
        while(!queue.isEmpty()) {
            int qlen = queue.size();
            
            for(int i=0; i<qlen; i++) {
                int cur = queue.poll();
                if(cur == n*n) return step; //If we reach to the last elements in the grid then return steps
                
                for(int k =1; k<=6; k++) {
                    if(cur+k>n*n) break; // Prevent to go out from grid
                    
                    int[] pos = findPossiblePositions(cur+k, n);
                    int r = pos[0];
                    int c = pos[1];
                    if(visited[r][c]) continue;
                    
                    visited[r][c] = true;
                    
                    if(board[r][c] == -1) {  //if we dont get -1 the there is a ladder and we have to pick a new value
                        queue.add(cur+k);
                    }else {
                        queue.add(board[r][c]); // otherwise next grid is w/o snake and ladder
                    }
                }
            }
            step++;
        }
        return -1;
    }
	 private static int[] findPossiblePositions(int cur, int n) {
	        int r = n - (cur-1)/n -1; // here we are doinf n-(equation) because we are counting grid from bottom
	        int c = (cur-1) % n;    
	        
	        if(r%2==n%2) {  // we have to check this condition because columns values are changing in zigzag way
	            return new int[]{r, n-1-c};
	        } else {
	            return new int[]{r,c};
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
