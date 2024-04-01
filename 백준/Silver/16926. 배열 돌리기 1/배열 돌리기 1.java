import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m,R,group;
    static int[][] board;
    static int[] dr = {0,1,0,-1}; // 오른쪽 , 아래, 왼쪽 , 위
    static int[] dc = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // n과 m중 작은 값 /2 만큼의 돌리는 부분이 생김
        group = Math.min(n,m) ;

        board = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<R; i++){
            rotate();
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void rotate(){
        for(int g=0; g<group/2; g++){
            int maxR = n-g-1;
            int maxC = m-g-1;
            int r = g;
            int c = g;
            int temp = board[g][g]; //초기 값
            for(int d=0; d<4; d++){ // 4방향
                int nr = r+ dr[d];
                int nc = c+ dc[d];
                while (nr>=g && nc>=g && nr<=maxR && nc<=maxC){
                    board[r][c] = board[nr][nc];
                    r = nr;
                    c = nc;
                    nr += dr[d];
                    nc += dc[d];
                }
            }
            board[g+1][g]= temp;
        }
    }
}
