import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][n];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> q = new LinkedList<>();
        int ans =0;
        // 오른쪽으로
        for (int i=0; i<n; i++){
            q.add(new int[] {i,0,0});
            boolean[] visited = new boolean[n];
            while (!q.isEmpty()){
                boolean dif = false;
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];
                int nx = cur[0];
                int ny = cur[1]+1;
                if (nx<0 || ny<0 || nx>=n || ny>=n) {
                    ans++;
                    continue; // 범위를 벗어나면 종료
                }
                if (Math.abs(board[nx][ny]-board[curX][curY])>1) {
                    break; // 차이가 1보다 크면 종료
                }
                if (board[curX][curY]==board[nx][ny]){
                    q.add(new int[] {nx,ny});
                }
                // 내리막
                else if(board[nx][ny]==board[curX][curY]-1 && !visited[ny]) {
                    // 하나 차이나고 k만큼 같으면 경사로를 설치, 경사로 길이만큼 넘어간다
                    for (int k=1; k<l; k++){
                        if (ny+k>=n || board[nx][ny]!=board[nx][ny+k]){
                            dif = true;
                            break;
                        }
                    }
                    if (dif) break;
                    visited[ny+l-1] = true;
                    q.add(new int[] {nx,ny+l-1});
                }
                // 오르막
                else if(board[nx][ny] ==board[curX][curY]+1 && !visited[curY]) {
                    for (int k=1; k<l; k++){
                        if (curY-k<0 || board[curX][curY]!=board[curX][curY-k] ||visited[curY] || visited[curY-k]){
                            dif =true;
                            break;
                        }
                    }
                    if (dif) break;
                    q.add(new int[] {nx,ny});
                }
            }
            q.clear();
        }
        // 아래로
        for (int i=0; i<n; i++){
            q.add(new int[] {0,i});
            boolean[] visited = new boolean[n];
            while (!q.isEmpty()){
                boolean dif = false;
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];
                int nx = cur[0]+1;
                int ny = cur[1];
                if (nx<0 || ny<0 || nx>=n || ny>=n) {
                    ans++;
                    continue; // 범위를 벗어나면 종료
                }
                if (Math.abs(board[nx][ny]-board[curX][curY])>1) {
                    break; // 차이가 1보다 크거나 오르막 일때 Q 리셋하고 종료
                }
                if (board[curX][curY]==board[nx][ny]){
                    q.add(new int[] {nx,ny});
                }
                // 내리막
                else if(board[nx][ny]==board[curX][curY]-1 && !visited[nx]) {
                    // 하나 차이나고 k만큼 같으면 경사로를 설치, 경사로 길이만큼 넘어간다
                    for (int k=1; k<l; k++){
                        if (nx+k>=n || board[nx][ny]!=board[nx+k][ny]){
                            dif = true;
                            break;
                        }
                    }
                    if (dif) break;
                    visited[nx+l-1] = true;
                    q.add(new int[] {nx+l-1,ny});
                }
                // 오르막
                else if(board[nx][ny] ==board[curX][curY]+1 && !visited[curX]) {
                    for (int k=1; k<l; k++){
                        if (curX-k<0 || board[curX][curY]!=board[curX-k][curY] || visited[curX-k] || visited[curX]){
                            dif =true;
                            break;
                        }
                    }
                    if (dif) break;
                    q.add(new int[] {nx,ny});
                }
            }
            q.clear();
        }
        System.out.println(ans);
    }
}
