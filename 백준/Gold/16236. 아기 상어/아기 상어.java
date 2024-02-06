import java.util.*;

public class Main {
    static int n,size,nxtX,nxtY,count,time;
    static int[][] board,distance;
    static boolean[][] visited;
    static Queue<int[]> q;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static boolean eatCheck;

    static void eat(){
        distance[nxtX][nxtY]=Integer.MAX_VALUE;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (distance[i][j]==0 || board[i][j]>=size ||board[i][j]==0) continue;
                if (distance[i][j]<distance[nxtX][nxtY] && board[i][j]<size){
                    nxtX = i;
                    nxtY = j;
                    eatCheck =true;
                }
            }
        }
        if (eatCheck) {
//            System.out.print("nxtX = " + nxtX);
//            System.out.print("  nxtY = " + nxtY);
//            System.out.println("  distance = " + distance[nxtX][nxtY]);
            time += distance[nxtX][nxtY];
            board[nxtX][nxtY] = 0;
            count++;
            sizeUp();
        }

    }
    static void sizeUp(){
        if (count==size){
            count =0;
            size++;
        }
    }
    static void dist(){
        q.clear();
        q.add(new int[] {nxtX,nxtY});
        visited[nxtX][nxtY] =true;
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int d=0; d<4; d++){
                int nx = curX + dx[d];
                int ny = curY + dy[d];
                if (nx<0||ny<0||nx>=n||ny>=n) continue;
                if (board[nx][ny]>size || visited[nx][ny]) continue;
                visited[nx][ny]=true;
                distance[nx][ny] = distance[curX][curY]+1;
                q.add(new int[]{nx,ny});
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        visited = new boolean[n][n];
        q = new LinkedList<>();
        distance = new int[n][n];
        size = 2;
        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 9) {
                    nxtX = i;
                    nxtY = j;
                    board[i][j]=0;
                }
            }
        }
        do {
            eatCheck = false;
            distance = new int[n][n];
            visited = new boolean[n][n];
            dist();
            eat();

        } while (eatCheck);
        System.out.println(time);
    }
}
