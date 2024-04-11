import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    /*
    알고스팟
    다익스트라 , 4번 코드 복붙해도 될듯;
     */
    static int n,m;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        int[][] dis = new int[n][m];
        for (int i=0; i<n; i++){
            char[] ch = br.readLine().toCharArray();
            for (int j=0; j<m; j++){
                board[i][j] = ch[j]-'0';
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
        pq.add(new Pair(0,0,0));
        dis[0][0] = 0;
        while (!pq.isEmpty()){
            Pair cur = pq.poll();
            if (cur.r==n-1 && cur.c==m-1){
                System.out.println(dis[cur.r][cur.c]);
                return;
            }
            for (int d=0; d<4; d++){
                int r = cur.r +dr[d];
                int c = cur.c +dc[d];
                if (!isValid(r,c) || cur.cost+board[r][c]>=dis[r][c]) continue;
                dis[r][c] = board[r][c] + cur.cost;
                pq.add(new Pair(r,c,dis[r][c]));
            }
        }

    }
    static boolean isValid(int r, int c){
        return r>=0 && c>=0 && r<n && c<m;
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
