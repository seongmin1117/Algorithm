import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    /*
    도둑루피
    다익스트라
     */
    static int n;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count =0;
        while ( (n= Integer.parseInt(br.readLine()))!=0){
            count++;
            int[][] board = new int[n][n];
            int[][] dis = new int[n][n];
            PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
                return o1.cost - o2.cost;
            });
            for (int i=0; i<n; i++){
                Arrays.fill(dis[i],Integer.MAX_VALUE);
            }
            for (int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<n; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            pq.add(new Pair(0,0,board[0][0]));
            while (!pq.isEmpty()){
                Pair cur = pq.poll();
                if (cur.r==n-1 && cur.c==n-1){
                    System.out.println("Problem "+count+": "+dis[n-1][n-1]);
                    break;
                }
                for (int d=0; d<4; d++){
                    int r = cur.r +dr[d];
                    int c = cur.c +dc[d];
                    if (!isValid(r,c) || board[r][c]+ cur.cost>=dis[r][c]) continue;
                    dis[r][c] = board[r][c] + cur.cost;
                    pq.add(new Pair(r,c,dis[r][c]));
                }
            }
        }

    }
    static boolean isValid(int r, int c){
        return r>=0 && c>=0 && r<n && c<n;
    }
    static class Pair{
        int r;
        int c;
        int cost;
        private Pair(int r, int c, int cost){
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
}
