import java.util.*;

public class Main {
    static int n,m,res;
    static int[][] board;
    static boolean[][] visited;
    static List<int[]> virus,space;
    static int[] dx ={1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    static void game(){
        for (int i=0; i<space.size(); i++){
            for (int j=i; j<space.size(); j++){
                if (i==j) continue;
                for (int k=j; k<space.size(); k++){
                    if (k==j) continue;
                    int[] wall1 = space.get(i);
                    int[] wall2 = space.get(j);
                    int[] wall3 = space.get(k);
                    board[wall1[0]][wall1[1]]=1;
                    board[wall2[0]][wall2[1]]=1;
                    board[wall3[0]][wall3[1]]=1;
                    bfs();
                    board[wall1[0]][wall1[1]]=0;
                    board[wall2[0]][wall2[1]]=0;
                    board[wall3[0]][wall3[1]]=0;
                }
            }
        }

    }
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        int[][] temp = new int[n][m];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                temp[i][j] = board[i][j];
            }
        }
        int count =0;
        q.addAll(virus);
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int d=0; d<4; d++){
                int nx = curX + dx[d];
                int ny = curY + dy[d];
                if (nx<0|| ny<0|| nx>=n || ny>=m) continue;
                if (temp[nx][ny] !=0) continue;
                temp[nx][ny]=2;
                q.add(new int[] {nx,ny});
            }
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (temp[i][j]==0) count++;
            }
        }

        res = Math.max(res,count);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        visited = new boolean[n][m];
        virus = new ArrayList<>();
        space = new ArrayList<>();
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                board[i][j] = sc.nextInt();
                if (board[i][j]==2){
                    virus.add(new int[] {i,j});
                }
                if (board[i][j]==0){
                    space.add(new int[] {i,j});
                }
            }
        }
        game();
        System.out.println(res);
    }
}
