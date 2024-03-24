import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m,space;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] board;
    static int[][] dis;
    static boolean[] visited;
    static List<int[]> inactive_virus, active_virus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        dis = new int[n][n];
        inactive_virus = new ArrayList<>();
        active_virus = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                // 비활성 바이러스 추가
                if(board[i][j]==2) {
                    inactive_virus.add(new int[] {i,j});
                }
                // 빈 칸이 아니면 거리 -1로 초기화
                if(board[i][j]==0){
                    space++;
                }
            }
        }
        visited = new boolean[inactive_virus.size()];
        backtrack(0,0);
        if (min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }
    static void backtrack(int k, int start){
        if(k==m){
            bfs();
        }
        for(int i=start; i< inactive_virus.size(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            active_virus.add(inactive_virus.get(i));
            backtrack(k+1,i+1);
            active_virus.remove(k);
            visited[i] = false;
        }
    }
    static void bfs(){
        int[][] temp = new int[n][n];
        int[][] time = new int[n][n];
        int count = space;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                temp[i][j] = board[i][j];
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i< active_virus.size(); i++){
            int[] cur = active_virus.get(i);
            int curX = cur[0];
            int curY= cur[1];
            q.add(new int[] {curX, curY});
            temp[curX][curY] = -1;
        }
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            for(int d=0; d<4; d++){
                int nx = curX +dx[d];
                int ny = curY+ dy[d];
                if(nx<0||ny<0||nx>=n||ny>=n ||time[nx][ny]!=0) continue;
                if(temp[nx][ny]==1 || temp[nx][ny]==-1) continue;
                if(temp[nx][ny]==0){
                    count--;
                    temp[nx][ny] = -1;
                    time[nx][ny] = time[curX][curY]+1;
                    q.add(new int[] {nx,ny});
                } else if(temp[nx][ny]==2 && count>0){
                    temp[nx][ny] = -1;
                    time[nx][ny] = time[curX][curY]+1;
                    q.add(new int[] {nx,ny});
                }
            }
        }
        if(count>0) return;
        int t = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                t = Math.max(t, time[i][j]);
            }
        }
        min = Math.min(t,min);
    }
}
