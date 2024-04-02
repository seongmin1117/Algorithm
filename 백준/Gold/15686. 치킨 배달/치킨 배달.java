import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    치킨배달
    집과 가장 가까운 치킨집의 거리 : 치킨거리
    치킨거리의 합 : 도시치킨거리

    N*N칸 , 1*1부터시작 , m개의 치킨집 고르기 (백트래킹)
    절댓갑 r2-r1 + c2-c1 으로 최소 판별 후 도시치킨거리 최소 갱싱
     */
    static int n,m,min;
    static int[][] board;
    static List<int[]> ck = new ArrayList<>();
    static List<int[]> home = new ArrayList<>();
    static int[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        selected = new int[m];
        min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==1){
                    home.add(new int[]{i,j});
                } else if(board[i][j]==2){
                    ck.add(new int[]{i,j});
                }
            }
        }
        bt(0,0);
        System.out.println(min);
    }
    static void bt(int k , int start){
        if(k==m){
            //치킨집 고르고 BFS 실행
            bfs(selected);
            return;
        }
        for(int i=start; i<ck.size(); i++){
            selected[k] = i;
            bt(k+1,i+1);

        }
    }
    static void bfs(int[] selected){

        int sum = 0;
        for(int i=0; i<home.size(); i++){
            int[] cur = home.get(i);
            int r1 = cur[0];
            int c1 = cur[1];
            int distance = Integer.MAX_VALUE;
            for (int j : selected) {
                int[] chicken = ck.get(j);
                int r2 = chicken[0];
                int c2 = chicken[1];
                int x = Math.abs(r2-r1) + Math.abs(c2-c1);
                distance = Math.min(x,distance);
            }
            sum += distance;
        }
        min = Math.min(min,sum);
    }
}
