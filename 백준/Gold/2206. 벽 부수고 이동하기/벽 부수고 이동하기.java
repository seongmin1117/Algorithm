import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
    벽부수고 이동하기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] board = new int[r][c];
        int[][][] dis  = new int[r][c][2];
        int[] dr = {1,0,-1,0};
        int[] dc = {0,-1,0,1};
        for (int i=0; i<r; i++){
            char[] ch = br.readLine().toCharArray();
            for (int j=0; j<c; j++){
                board[i][j] = ch[j]-'0';
            }
        }
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0,0));
        dis[0][0][0]=1; // 시작도 카운팅
        
        while (!q.isEmpty()){
            Node node = q.poll();
            // 도착하면 출력 후 종료
            if (node.r ==r-1 && node.c == c-1){
                System.out.println(dis[node.r][node.c][node.broken]);
                return;
            }
            for (int d=0; d<4; d++){
                int nr = node.r +dr[d];
                int nc = node.c +dc[d];

                if (nr<0 || nc<0 || nr>=r || nc>=c) continue;

                // 벽이 아니고 방문한 적이 없을 때 거리 동기화
                if (board[nr][nc]==0 && dis[nr][nc][node.broken]==0){
                    dis[nr][nc][node.broken] = dis[node.r][node.c][node.broken]+1;
                    q.add(new Node(nr,nc, node.broken));
                }
                // 벽인데 부순적이 없고 부수고 방문한 적이 없을 때, 부수고 거리 동기화
                if (board[nr][nc]==1 && node.broken==0 && dis[nr][nc][1]==0){
                    dis[nr][nc][1] = dis[node.r][node.c][node.broken]+1;
                    q.add(new Node(nr,nc,1));
                }

            }
        }
        System.out.println(-1);
    }
    static class Node{
        int r;
        int c;
        int broken;
        Node(int r, int c, int broken) {
            this.r = r;
            this.c = c;
            this.broken = broken;
        }

    }
}
