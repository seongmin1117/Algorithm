import java.util.*;

class Solution
{
    static int[][] board;
    static boolean[][] visited;
    static int x1,y1,x2,y2;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,-1,0,1};
	public static void main(String args[]) throws Exception
	{
		 Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int t = sc.nextInt();
            board = new int[16][16];
            visited = new boolean[16][16];
            int answer = 0;
           for(int i=0; i<16; i++){
           	String row = sc.next();
               for(int j=0; j<16; j++) {
               		board[i][j] = row.charAt(j) -'0';
                   if(board[i][j] ==2){
                   	x1 = i;
                       y1 = j;
                   }
                   if(board[i][j] ==3) {
                   x2 =i;
                       y2 = j;
                   }
               }
           }
            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.addLast(new int[]{x1,y1});
                  visited[x1][y1] = true;
			while(!q.isEmpty()){
            	int[] cur = q.pollFirst();
                int r = cur[0]; int c = cur[1];
                if(r==x2 && c==y2){
                	answer = 1;
                    break;
                }
                for(int d=0; d<4; d++){
                	int nr = r+dr[d];
                    int nc = c+dc[d];
                    if(nr<0 || nc<0 || nr>=15 || nc>=15) continue;
                    if(board[nr][nc]==1 || visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    q.addLast(new int[]{nr,nc});
                }
            }
            System.out.println("#"+test_case+" "+ answer);
		}
	}
}