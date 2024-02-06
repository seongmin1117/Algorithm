import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m,h,min=4;
    static int[][] board;
    static void dfs(int x, int count){
        // 추가할 사다리가 3개보다 크면 종료
        if (count>3) return;

        // 여기서 실행하고 true면 답 갱신후 종료
        if (check()){
            min = Math.min(min,count);
            return;
        }
        //조합
        for (int i=x; i<h+1; i++){
            for (int j=1; j<n; j++){
                if (board[i][j]==0 && board[i][j+1]==0){
                    board[i][j]=1;
                    board[i][j+1]=2;
                    dfs(i,count+1);
                    board[i][j]=board[i][j+1]=0;
                }
            }
        }
    }
    static boolean check(){
        for (int i=1; i<n+1; i++){
            int x = 1;
            int y = i;
            while (x<h+1){
                if (x<0||y<0||x>h||y>n) break;
                if (board[x][y]==1){
                    y++;
                    x++;
                } else if (board[x][y]==2){
                    y--;
                    x++;
                }else if (board[x][y] ==0){
                    x++;
                }
            }
            if (y!=i) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로선의 개수
        m = Integer.parseInt(st.nextToken()); // 가로선의 개수
        h = Integer.parseInt(st.nextToken()); // 가로선을 넣을수 있는 위치 h
        board= new int[h+1][n+1];

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = 1; // 1이면 오른쪽으로  2면 왼쪽으로
            board[a][b+1] = 2;
        }
        dfs(1,0);
        System.out.println( min!=4 ? min : -1);
    }
}
