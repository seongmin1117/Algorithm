import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
    나이트의 이동

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {1, -1, 2, -2, -2, 2, 1, -1};
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int l = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            if (x1==x2 && y1==y2){
                sb.append(0).append("\n");
                continue;
            }
            int[][] dis = new int[l][l];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{x1, y1});

            outer:
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];

                for (int dir = 0; dir < 8; dir++) {
                    int nx = curX + dx[dir];
                    int ny = curY + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= l || ny >= l || dis[nx][ny] != 0) continue;
                    dis[nx][ny] = dis[curX][curY] + 1;
                    if (nx == x2 && ny == y2) {
                        sb.append(dis[nx][ny]).append("\n");
                        break outer;
                    }
                    q.add(new int[]{nx, ny});
                }
            }
        }
        System.out.println(sb);
    }
}
