import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m,cnt;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] finished;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        finished = new boolean[n][m];
        for (int i=0; i<n; i++){
            String s  = br.readLine();
            for (int j=0; j<m; j++){
                map[i][j] = s.charAt(j);
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                // 방문한 적 없는 노드만 dfs
                if (!visited[i][j]){
                    dfs(i,j);
                }
            }
        }
        System.out.println(cnt);
    }
    static void dfs(int r, int c){
        visited[r][c] = true;
        char dir = map[r][c];
        int nr = r; int nc = c;
        switch (dir){
            case 'D':
                nr++;
                break;
            case 'R':
                nc++;
                break;
            case 'U':
                nr--;
                break;
            case 'L':
                nc--;
                break;
        }
        if (!visited[nr][nc]){
            dfs(nr,nc);
        } else {
            if (!finished[nr][nc]){
                cnt++;
            }
        }
        finished[r][c] = true;
    }
}
