import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m,count;
    static int min = Integer.MAX_VALUE;
    static int[][] board;
    static Queue<int[]> q = new LinkedList<>();

    static List<int[]> virus = new ArrayList<>();
    static boolean[] visited = new boolean[50];
    static int[] v = new int[10];
    static boolean chk = false;
    static void dfs(int k){
        if (k==m){
            for (int i=0; i<m; i++){
                int[] cur = virus.get(v[i]);
                board[cur[0]][cur[1]] =3;
            }
            game();
            for (int i=0; i<m; i++){
                int[] cur = virus.get(v[i]);
                board[cur[0]][cur[1]] =2;
            }
            return;
        }
        int st =0;
        if (k>0){
            st =v[k-1];
        }
        for (int i=st; i<virus.size(); i++){
            if (visited[i]) continue;
            visited[i]= true;
            v[k] = i;
            dfs(k+1);
            visited[i]=false;
        }
    }
    static int[] dx = {1,0,-1,0};
    static int [] dy= {0,-1,0,1};
    static void game(){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (board[i][j]==3) q.add(new int[] {i,j,0});
            }
        }
        int[][] temp = new int[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                temp[i][j] = board[i][j];
            }
        }
        int day = 0;
        int zero = 0;
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            day = cur[2];
            zero++;
            for (int d=0; d<4; d++){
                int nx = x+dx[d];
                int ny = y+dy[d];
                if (nx<0||ny<0||nx>=n||ny>=n) continue;
                if (temp[nx][ny]!=0 && temp[nx][ny]!=2) continue;
                temp[nx][ny] = -1;
                q.add(new int[] {nx,ny,day+1});
            }
        }
        if (zero ==count){
            chk =true;
           min = Math.min(min,day);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                board[i][j] =Integer.parseInt(st.nextToken());
                if (board[i][j]!=1) count++;
                if (board[i][j]==2) virus.add(new int[] {i,j});
            }
        }
        dfs(0);
        if (!chk) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }
}
