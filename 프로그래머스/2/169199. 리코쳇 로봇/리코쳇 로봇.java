import java.util.*;

class Solution {
    static class Point {
        int x, y, cnt;
        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public int solution(String[] board) {
        int h = board.length;
        int w = board[0].length();
        
        char[][] map = new char[h][w];
        boolean[][] visited = new boolean[h][w];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int sx = 0;
        int sy = 0;

        for (int i = 0; i < h; i++) {
            map[i] = board[i].toCharArray();
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 'R') {
                    sx = i;
                    sy = j;
                }
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(sx, sy, 0));
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (map[p.x][p.y] == 'G') return p.cnt;

            for (int d = 0; d < 4; d++) {
                int nx = p.x;
                int ny = p.y;

                while (true) {
                    int tx = nx + dx[d];
                    int ty = ny + dy[d];

                    if (tx < 0 || ty < 0 || tx >= h || ty >= w || map[tx][ty] == 'D') break;

                    nx = tx;
                    ny = ty;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny, p.cnt + 1));
                }
            }
        }

        return -1;
    }
}
