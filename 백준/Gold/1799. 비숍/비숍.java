import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, b, w;
    static int[][] map;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bt(0, 0, 0,0);
        bt(0, 1, 0,1);
        System.out.println(b + w);
    }

    static void bt(int r, int c, int count, int color) {

        if (c >= n) {
            r++;
            c = (c % 2 == 0) ? 1 : 0; // 다음 행으로 이동
        }
        if (r >= n) {
            // 흑
            if (color== 0) {
                b = Math.max(b, count);
            }
            // 백
            else {
                w = Math.max(w, count);
            }
            return;
        }
        if (map[r][c] == 1 && go(r, c)) {
            map[r][c] = -1;
            bt(r, c+2, count + 1,color);
            map[r][c] = 1;
        }
        bt(r, c+2, count,color);
    }

    static boolean go(int r, int c) {
        for (int dir = 0; dir < 4; dir++) {
            int nr = r;
            int nc = c;
            while (true) {
                nr += dx[dir];
                nc += dy[dir];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) break;
                if (map[nr][nc] == -1) return false;
            }
        }
        return true;
    }

}
