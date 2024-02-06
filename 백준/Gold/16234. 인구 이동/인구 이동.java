import java.util.*;

public class Main {
    static int n,l,r,day;
    static int[][] board;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static Queue<int[]> q2 = new LinkedList<>();
    static boolean re = false;
    static boolean check(int x1, int y1, int x2, int y2){
        int a = Math.abs(board[x1][y1]-board[x2][y2]);
        return a >= l && a <= r;
    }
    static void bfs() {
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    List<int[]> union = new ArrayList<>();
                    q.add(new int[]{i, j});
                    int sum = 0;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int curX = cur[0];
                        int curY = cur[1];
                        if (visited[curX][curY]) continue; // Skip if visited
                        visited[curX][curY] = true;
                        union.add(new int[]{curX, curY});
                        sum += board[curX][curY];
                        for (int d = 0; d < 4; d++) {
                            int nx = curX + dx[d];
                            int ny = curY + dy[d];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                            if (visited[nx][ny]) continue;
                            if (!check(curX, curY, nx, ny)) continue;
                            re = true;
                            q.add(new int[]{nx, ny});
                        }
                    }
                    int avg = sum / union.size(); // Calculate average
                    for (int[] pos : union) {
                        board[pos[0]][pos[1]] = avg; // Update board
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt(); // l명 이상
        r = sc.nextInt(); // r명 이하
        board = new int[n][n];
        visited = new boolean[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                board[i][j] = sc.nextInt();
            }
        }
        day =0;
        do {
            re=false;
            bfs();
            if (re) day++;
        } while (re);
        System.out.println(day);

    }
}
