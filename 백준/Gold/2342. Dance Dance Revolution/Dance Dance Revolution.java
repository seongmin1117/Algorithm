import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<Integer>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int n = list.size()-1;

        /*
        0차이가 나면 +1
        0이 있으면 +2
        1차이가 나면 +3
        2차이가 나면 +4
         */
        int[][][] dp = new int[5][5][n+1];

        //초기화
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        //초기값
        int start = list.get(0);
        dp[start][0][1] = 2;
        dp[0][start][1] = 2;

        for (int i = 1; i < n; i++) {
            int temp = list.get(i);
            for (int left = 0; left < 5; left++) {
                for (int right = 0; right < 5; right++) {
                    if (dp[left][right][i] != Integer.MAX_VALUE) {
                        dp[temp][right][i + 1] = Math.min(dp[temp][right][i + 1], dp[left][right][i] + move(left, temp));
                        dp[left][temp][i + 1] = Math.min(dp[left][temp][i + 1], dp[left][right][i] + move(right, temp));
                    }
                }
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int left = 0; left < 5; left++) {
            for (int right = 0; right < 5; right++) {
                minCost = Math.min(minCost, dp[left][right][n]);
            }
        }

        System.out.println(minCost);
    }
    static int move(int a, int b){
        int c = Math.abs(a-b);
        if (a==b){
            return 1;
        }
        if (a==0){
            return 2;
        }
        if (c==1||c==3){
            return 3;
        }
        if (c==2){
            return 4;
        }
        return 0;
    }
}
