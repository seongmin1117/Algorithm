import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n,max;
    static int[] swing = new int[9];
    static int[][] board;
    static boolean[] visited = new boolean[9];
    static void dfs(int k){
        if (k==9){
            if (swing[3]==0){
                game();
            }
            return;
        }
        for (int i=0; i<9; i++){
            if (visited[i]) continue;
            visited[i] = true;
            swing[k] = i;
            dfs(k+1);
            visited[i] =false;
        }
    }
    static void game(){
        int start = 0;
        int point =0;
        for (int i=0; i<n; i++){
            int out =0;
            int[] ground = new int[3];
            while (out<3) {
                for (int j = 0; j < 9; j++) {
                    int idx = (start + j) % 9;
                    int cur = swing[idx]; // 타자
                    int a = board[i][cur];
                    if (a == 0) {
                        out++;
                        if (out == 3) {
                            start = idx+1;
                            break;
                        }
                    } else if (a == 1) {
                        if (ground[2] == 1) point++;
                        for (int k = 2; k > 0; k--) {
                            ground[k] = ground[k - 1];
                        }
                        ground[0] = 1;
                    } else if (a == 2) {
                        if (ground[2] == 1) point++;
                        if (ground[1] == 1) point++;
                        ground[2] = ground[0];
                        ground[1] = 1;
                        ground[0] = 0;

                    } else if (a == 3) {
                        if (ground[2] == 1) point++;
                        if (ground[1] == 1) point++;
                        if (ground[0] == 1) point++;
                        ground[2] = 1;
                        ground[1] = 0;
                        ground[0] = 0;

                    } else if (a == 4) {
                        point++;
                        for (int k = 0; k < 3; k++) {
                            if (ground[k] == 1) point++;
                            ground[k] = 0;
                        }
                    }
                }
            }
        }
        max = Math.max(max,point);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][9];
        for (int i=0; i<n; i++){
            for (int j=0; j<9; j++){
                board[i][j] = sc.nextInt();
            }
        }
        dfs(0);
        System.out.println(max);
    }
}
