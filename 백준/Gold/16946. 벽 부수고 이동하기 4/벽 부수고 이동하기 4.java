import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int n,m;
    static int[][] map;
    static int[][] group;
    static int[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        group = new int[n][m];
        int id = 1;
        size = new int[n*m+1];
        for (int i=0; i<n; i++){
            String[] s = br.readLine().split("");
            for (int j=0; j<m; j++){
                map[i][j] = s[j].charAt(0)-'0';
            }
        }

        for (int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j]!=0) continue;
                if (group[i][j] !=0) continue;
                int cnt = bfs(i,j,id);
                size[id] = cnt;
                id++;
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j]==0) continue;
                HashSet<Integer> set = new HashSet<>();
                int total = 1;
                for (int k=0; k<4; k++) {
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if (nx<0 || ny<0 || nx>=n || ny>=m) continue;
                    if (group[nx][ny]==0) continue;
                    set.add(group[nx][ny]);
                }
                for (int groupId : set) {
                    total += size[groupId];
                }
                map[i][j] = total%10;
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                bw.write(String.valueOf(map[i][j]));
            }
            bw.newLine();
        }
        bw.flush();

    }
    static int bfs(int r,int c, int id){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r,c});
        group[r][c] = id;
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k=0; k<4; k++) {
                int nx = cur[0]+dx[k];
                int ny = cur[1]+dy[k];
                if (nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if (map[nx][ny]!=0 || group[nx][ny]!=0) continue;
                group[nx][ny] = id;
                cnt++;
                q.add(new int[] {nx,ny});
            }
        }
        return cnt;
    }
}
