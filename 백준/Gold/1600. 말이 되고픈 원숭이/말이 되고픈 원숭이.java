import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r,c,answer;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,-1,0,1};
    static int[] dx = {-2,-2,-1,-1,1,1,2,2};
    static int[] dy = {-1,1,-2,2,-2,2,-1,1};
    static int[][] board;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        board = new int[r][c];
        visited = new boolean[r][c][k+1];
        for (int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<c; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(0,0,k));
    }
    static int bfs(int x, int y, int count){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(x,y,count,0));
        visited[x][y][count] = true;
        while (!q.isEmpty()){

            Node cur = q.poll();
            if (cur.x== r-1 && cur.y== c-1){
                return cur.dist;
            }

            for (int d=0; d<4; d++){
                int nx = cur.x + dr[d];
                int ny = cur.y + dc[d];
                if (isValid(nx,ny)&& !visited[nx][ny][cur.count]){
                    visited[nx][ny][cur.count] = true;
                    q.add(new Node(nx,ny,cur.count,cur.dist+1));
                }
            }
            if (cur.count>0){
                for (int d=0; d<8; d++){
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (isValid(nx,ny) &&!visited[nx][ny][cur.count-1]){
                        visited[nx][ny][cur.count-1] = true;
                        q.add(new Node(nx,ny,cur.count-1,cur.dist+1));
                    }
                }
            }
        }
        return -1;


    }
    static boolean isValid(int x, int y){
        return x>=0&&x<r&&y>=0&&y<c&&board[x][y]==0;
    }
    static class Node {
        int x, y, count, dist;

        public Node(int x, int y, int count, int dist) {
            this.x = x;
            this.y = y;
            this.count = count; // 남은 말 이동 횟수
            this.dist = dist;   // 이동 거리
        }
    }
}
