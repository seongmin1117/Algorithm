import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map,dp;
    static int n,m;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0,0));
    }
    static int dfs(int r, int c){
        // 도착한 경우
        if (r == m-1 && c == n-1) {
            return 1;
        }
        // 이미 탐색한 경로가 있을 경우
        if (dp[r][c]!=-1){
            return dp[r][c];
        }
        dp[r][c] = 0;
        
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
            if (!compare(map[r][c],map[nr][nc])) continue;
            dp[r][c] += dfs(nr,nc);
        }
        return dp[r][c];
    }
    static boolean compare(int x, int y){
        return x>y;
    }
}
