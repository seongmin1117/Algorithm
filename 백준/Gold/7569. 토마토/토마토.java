import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
    토마토
    1 : 익은 토마토 , 0 : 익지 않은 토마토, -1 :  빈칸
     */
    static int n,m,H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        int[][][] board = new int[n][m][H];
        Queue<Tomato> q = new LinkedList<>();
        int[] dr = {1,0,-1,0,0,0};
        int[] dc = {0,-1,0,1,0,0};
        int[] dh = {0,0,0,0,1,-1};
        int count = 0;
        for (int k=0; k<H; k++){
            for (int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<m; j++){
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (board[i][j][k]==1){
                       q.add(new Tomato(i,j,k,0));
                    }
                    if (board[i][j][k]==0){
                        count++;
                    }
                }
            }
        }
        if (count==0) {
            System.out.println(0);
            return;
        }
        while (!q.isEmpty()){
            Tomato tomato = q.poll();
            for (int d=0; d<6; d++){
                int nr = tomato.r +dr[d];
                int nc = tomato.c +dc[d];
                int nh = tomato.h +dh[d];
                if (!isValid(nr,nc,nh) || board[nr][nc][nh]!=0) continue;
                count--;
                if (count==0){
                    System.out.println(tomato.day+1);
                    return;
                }
                board[nr][nc][nh]=1;
                q.add(new Tomato(nr,nc,nh, tomato.day+1));
            }
        }
        if (count>0) System.out.println(-1);

    }
    static boolean isValid(int r, int c, int h){
        return r>=0 && c>=0 && h >=0 && r<n && c<m && h<H;
    }
    static class Tomato{
        int r;
        int c;
        int h;
        int day;
        Tomato(int r, int c, int h, int day){
            this.r = r;
            this.c = c;
            this.h = h;
            this.day = day;
        }
    }
}
