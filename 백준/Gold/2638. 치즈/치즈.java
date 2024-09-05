import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) count++;
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int answer = 0;
        while (true){
            answer++;
            if (count==0){
                System.out.println(answer);
                return;
            }
            boolean[][] visited = new boolean[n][m];
            int[][] check = new int[n][m];
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{0, 0});
            visited[0][0] = true;
            while(!q.isEmpty()){
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                    if(visited[nr][nc]) continue;
                    if (board[nr][nc] == 0) {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                    if (board[nr][nc] == 1) {
                        check[nr][nc]++;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(check[i][j] <2) continue;
                    board[i][j] = 0;
                    count --;
                    if (count == 0) {
                        System.out.println(answer);
                        return;
                    }
                }
            }
        }
    }
}
