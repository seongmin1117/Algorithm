import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dr = {1,0,-1,0};
        int[] dc = {0,1,0,-1};

        // 대륙 3개로 나누기
        List<int[]> group = new ArrayList<int[]>();
        int start = 2;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j]) continue;
                if (map[i][j]!=1) continue;
                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[] {i, j});
                visited[i][j] = true;
                start++;
                map[i][j] = start;
                group.add(new int[] {i, j});
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int r = cur[0];
                    int c = cur[1];
                    for (int d=0; d<4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (nr<0 || nc<0 || nr>=n || nc>=n) continue;
                        if (visited[nr][nc]) continue;
                        if (map[nr][nc]==0) continue;
                        visited[nr][nc] = true;
                        map[nr][nc] = start;
                        q.offer(new int[] {nr, nc});
                    }
                }
            }
        }

        // 이제 최단거리 찾기
        int answer = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (map[i][j]==0) continue;
                Queue<int[]> q = new ArrayDeque<>();
                visited = new boolean[n][n];
                q.offer(new int[] {i, j,0});
                int num = map[i][j];
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int r = cur[0];
                    int c = cur[1];
                    int dis = cur[2];
                    if (map[r][c]!=num && map[r][c]!=0) {
                        answer = Math.min(answer, dis-1);
                    }
                    for (int d=0; d<4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (nr<0 || nc<0 || nr>=n || nc>=n) continue;
                        if (map[nr][nc]==num || visited[nr][nc]) continue;
                        visited[nr][nc] = true;
                        q.offer(new int[] {nr, nc, dis+1});

                    }
                }
            }
        }
        System.out.println(answer);
    }
}
