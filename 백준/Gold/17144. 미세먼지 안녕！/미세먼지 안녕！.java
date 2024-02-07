import java.util.*;

public class Main {
    static int r,c,t;
    static int[][] board;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,-1,0,1};
    static List<Integer> air;
    static Queue<int[]> q;
    static void diff(){
        int[][] temp = new int[r][c];
        for (int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                if (board[i][j]>0) q.add(new int[] {i,j});
            }
        }
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int dust = board[curX][curY];
            List<int[]> dir = new ArrayList<>();
            for (int d=0; d<4; d++){
                int nx = curX + dx[d];
                int ny = curY + dy[d];
                if (nx<0||ny<0||nx>=r||ny>=c) continue;
                if (board[nx][ny]==-1) continue;
                dir.add(new int[] {nx,ny});
            }
            int avg = dust/5;
            for (int[] a : dir){
               int x = a[0];
               int y = a[1];
               temp[x][y] += avg; // 확산하고
               board[curX][curY] -=avg; // 그만큼 빼기
            }
        }
        // 다 끝나면 확산된 만큼 더해주기
        for (int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                board[i][j] += temp[i][j];
            }
        }
    }
    static void wind1(){
        Integer a = air.get(0);
        // 하 좌 상 우
        for (int i=a-1; i>0; i--){
            int temp = board[i-1][0];
            board[i][0]=temp;
        }
        for (int i=0; i<c-1; i++){
            int temp = board[0][i+1];
            board[0][i] = temp;
        }
        for (int i=0; i<a; i++){
            int temp = board[i+1][c-1];
            board[i][c-1]= temp;
        }
        for (int i=c-1; i>0; i--){
            int temp = board[a][i-1];
            board[a][i] = temp;
        }
        board[a][1] =0;
    }
    static void wind2(){
        Integer a = air.get(1);
        // 상 좌 하 우
        for (int i=a+1; i<r-1; i++){
            int temp = board[i+1][0];
            board[i][0] = temp;
        }
        for (int i=0; i<c-1; i++){
            int temp = board[r-1][i+1];
            board[r-1][i] = temp;
        }
        for (int i=r-1; i>a; i--){
            int temp = board[i-1][c-1];
            board[i][c-1]= temp;
        }
        for (int i=c-1; i>1; i--){
            int temp = board[a][i-1];
            board[a][i] =temp;
        }
        board[a][1]=0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        t = sc.nextInt();
        board = new int[r][c];
        air = new ArrayList<>();
        q = new LinkedList<>();
        for (int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                board[i][j]= sc.nextInt();
                if (board[i][j]==-1){
                    air.add(i);
                }
            }
        }
        while (t>0){
            diff();
            wind1();
            wind2();
            t--;
        }
        int ans = 2;
        for (int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                ans += board[i][j];
            }
        }
        System.out.println(ans);
    }
}
