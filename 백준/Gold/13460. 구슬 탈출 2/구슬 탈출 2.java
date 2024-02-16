import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m,exit1,exit2,count,answer;
    static int x1,y1,x2,y2;

    static int[] red = new int[2];
    static int [] blue = new int[2];

    static List<int[]> dis = new ArrayList<>();

    static boolean chk,over;
    static int[][] board;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};


    static void game(int rx, int ry, int bx, int by, int dir){
        count++;
        x1 = rx;
        y1 = ry;
        x2 = bx;
        y2 = by;

        // 블루 이동
        while (board[x2+dx[dir]][y2+dy[dir]]==0){
            x2 +=dx[dir];
            y2 +=dy[dir];
        }
        // 블루가 탈출하면 실패
        if (board[x2+dx[dir]][y2+dy[dir]]==-1) {
            over =true;
            return;
        }
        // 레드 이동
        while (board[x1+dx[dir]][y1+dy[dir]]==0){
            x1 += dx[dir];
            y1 += dy[dir];
        }
        //탈출 성공
        if (board[x1+dx[dir]][y1+dy[dir]]==-1){
            chk = true;
            return;
        }
        // 같은 곳이면 이동거리가 큰 색이 -1
        if (x1==x2 && y1==y2){
            int r = Math.abs(x1+y1-rx-ry);
            int b = Math.abs(x2+y2-bx-by);
            if (r>b) {
                x1 -= dx[dir];
                y1 -= dy[dir];
            } else {
                x2 -= dx[dir];
                y2 -= dy[dir];
            }
    }
        }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i=0; i<n; i++){
            String[] split = br.readLine().split("");
            for (int j=0; j<m; j++){
                if (split[j].equals(".")) board[i][j]=0;
                if (split[j].equals("#")) board[i][j]=1;
                if (split[j].equals("B")) {
                    board[i][j]=0;
                    blue[0] = i;
                    blue[1] = j;
                }
                if (split[j].equals("R")) {
                    board[i][j]=0;
                    red[0] = i;
                    red[1] = j;
                }
                if (split[j].equals("O")) {
                    board[i][j]=-1;
                    exit1 = i;
                    exit2 = j;
                }
            }
        }
        answer = Integer.MAX_VALUE;
        List<int[]> ans = new ArrayList<>();
        for (int i=0; i< (1<<20); i++){
            int temp = i;
            count =0;
            chk = false;
            over =false;
            x1 = red[0];
            y1 = red[1];
            x2 = blue[0];
            y2 = blue[1];
            dis.clear();
            for (int j=0; j<10; j++){
                int dir = temp%4;
                temp/=4;
                game(x1,y1,x2,y2,dir);
                // 탈출 실패하면 다음으로
                if (over){
                    break;
                }
                if (chk) {
                    answer = Math.min(count,answer);
                    break;
                };
            }
        }
        if (answer==Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
