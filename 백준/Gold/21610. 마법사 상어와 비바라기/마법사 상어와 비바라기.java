import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    /*
    마법사 상어와 비바라기
    8방향 , 1부터 N까지,

    1. 모든 구름이 di 방향으로 si칸 이동
    2. 각 구름에서 비가 내려 구름이 있는 칸 물+1
    3. 구름이 사라진다.
    4. 2번 칸에서 증가한 물들은 범위 안에 있는 대각선에 물이 있는만큼 1씩 더 증가한다.
    5. 2번에 있던 칸을 제외한 물의 양이 2이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다.

    시작 구름은 (N,1) (N,2) (N-1,1) (N-1,2)
     */
    static int n,m;
    static int[] dr = {9,0,-1,-1,-1,0,1,1,1};
    static int[] dc = {9,-1,-1,0,1,1,1,0,-1};

    static int[] dx = {1,1,-1,-1};
    static int[] dy = {1,-1,1,-1};
    static int[][] board;
    static boolean[][] rain;
    static Queue<Pair> q = new ArrayDeque<>();
    static Queue<Cloud> cloud = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            q.add(new Pair(d,s));
        }
        for (int i=n-2; i<n; i++){
            for (int j=0; j<2; j++){
                cloud.add(new Cloud(i,j));
            }
        }
        while (!q.isEmpty()){
            Pair cur = q.poll();
            two(cur.d, cur.s);
            four();
            five();
        }
        int answer = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                answer += board[i][j];
            }
        }
        System.out.println(answer);
    }
    static void two(int d, int s){
        rain = new boolean[n][n];
        for (int i=0; i< cloud.size(); i++){
            Cloud cur = cloud.poll();
            cur.move(d,s);
            rain[cur.r][cur.c] = true;
            board[cur.r][cur.c]++;
            cloud.add(cur);
        }
    }
    static void four(){
        while (!cloud.isEmpty()){
            Cloud cur = cloud.poll();
            for (int i=0; i<4; i++){
                int r = cur.r + dx[i];
                int c = cur.c + dy[i];
                if (!isValid(r,c) || board[r][c]==0) continue;
                board[cur.r][cur.c]++;
            }
        }
    }
    static void five(){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (rain[i][j] || board[i][j]<2) continue;
                board[i][j] -=2;
                cloud.add(new Cloud(i,j));
            }
        }
    }
    static boolean isValid(int r, int c){
        return r>=0 && c>=0 && r<n && c<n;
    }
    static class Pair{
        int d;
        int s;
         protected Pair(int d, int s){
             this.d = d;
             this.s = s;
         }
    }
    static class Cloud{
        int r;
        int c;
        protected Cloud(int r, int c){
            this.r = r;
            this.c = c;
        }
        protected  void move (int d, int s){
            r += (dr[d]*s)%n +n;
            c += (dc[d]*s)%n +n;
            r%=n;
            c%=n;
        }
    }
}
