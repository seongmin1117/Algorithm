import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[][] board = new char[n][n];
        char[][] board2 = new char[n][n];
        boolean[][] visited = new boolean[n][n];
        boolean[][] visited2 = new boolean[n][n];
        for (int i=0; i<n; i++){
            char[] row = scanner.next().toCharArray();
            for (int j=0; j<n; j++){
                board[i][j] = row[j];
                if (row[j]=='G') {board2[i][j] = 'R';}
                else {board2[i][j] = row[j];}

            }
        }
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        int count = 0;
        int count2 = 0;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (!visited[i][j]) {
                q.add(new int[] {i,j});
                count++;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int curX = cur[0];
                    int curY = cur[1];
                    char target = board[curX][curY];

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = curX + dx[dir];
                        int ny = curY + dy[dir];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        if (visited[nx][ny] || board[nx][ny] != target) continue;

                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        }
                    }
                }
                if (!visited2[i][j]) {
                    q2.add(new int[] {i,j});
                    count2++;
                    while (!q2.isEmpty()) {
                        int[] cur = q2.poll();
                        int curX = cur[0];
                        int curY = cur[1];
                        char target = board2[curX][curY];

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = curX + dx[dir];
                            int ny = curY + dy[dir];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                            if (visited2[nx][ny] || board2[nx][ny] != target) continue;

                            visited2[nx][ny] = true;
                            q2.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        System.out.println(count+" "+count2);
    }
}
