import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n,m,answer;
    static char[][] board;
    static int[] blue= new int[2];
    static int[] red= new int[2];
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,-1,0,1};
    static int[] dir = new int[10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new char[n][m];

        for(int i=0; i<n; i++){
            char[] ch = sc.next().toCharArray();
            for(int j=0; j<m; j++){
                board[i][j] = ch[j];
                if(board[i][j] == 'B'){
                    blue[0] = i;
                    blue[1] = j;
                    board[i][j] = '.';
                }
                if(board[i][j] =='R'){
                    red[0] = i;
                    red[1] = j;
                    board[i][j] = '.';
                }
            }
        }
        bt(0,-1);
        System.out.println(answer);
    }
    static void bt(int k, int pre){
        if(k==10){
            bfs();
            return;
        }
        for(int i=0; i<4; i++){
            if(i==pre) continue;
            dir[k] = i;
            bt(k+1,i);
        }

    }
    //하 우 상 좌
    static void bfs(){
        int blue_r = blue[0];
        int blue_c = blue[1];
        int red_r = red[0];
        int red_c = red[1];
        //10번 이동
        for(int i=0; i<10; i++){
            int d = dir[i]; //현재 방향
            int nr = blue_r + dr[d];
            int nc = blue_c + dc[d];
            int b_dis = 0; //이동거리

            //파란공 이동
            while(board[nr][nc]!='#'){
                if(board[nr][nc]=='O') return;
                blue_r = nr;
                blue_c = nc;
                b_dis++;
                nr += dr[d];
                nc += dc[d];
            }

            //빨간 공 이동
            nr = red_r +dr[d];
            nc = red_c +dc[d];
            int r_dis = 0;
            while (board[nr][nc]!='#'){
                if(board[nr][nc]=='O' ){
                    answer =1;
                    return;
                }
                red_r = nr;
                red_c = nc;
                r_dis++;
                nr += dr[d];
                nc += dc[d];
            }
            // 이동했는데 위치가 같으면 이동거리가 큰 쪽을 한칸 뒤로
            if(blue_r==red_r && blue_c==red_c) {
                if(b_dis > r_dis){
                    blue_r -= dr[d];
                    blue_c -= dc[d];
                } else {
                    red_r -= dr[d];
                    red_c -= dc[d];
                }
            }
        }
    }
}
