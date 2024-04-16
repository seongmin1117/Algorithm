import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    스티커
    테스트케이스
    1<= N <=100000
     */
    static int[][] board = new int[2][100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb  = new StringBuilder();
        while (T-- >0){
            int n = Integer.parseInt(br.readLine());
            int answer;
            for (int i=0; i<2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[2][n];
            dp[0][0] = board[0][0];  // dp[0][i] = dp[1][i-1]+board[0][i]  or dp[1][i-2]
            dp[1][0] = board[1][0]; // dp[1][i] = dp[0][i-1] +board[1][i] or dp[0][i-2]
            if (n==1) {
                answer = Math.max(dp[0][0],dp[1][0]);
                sb.append(answer).append("\n");
                continue;
            }
            dp[0][1] = dp[1][0] + board[0][1];
            dp[1][1] = dp[0][0] + board[1][1];
            for (int i=2; i<n; i++){
                dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2])+board[0][i];
                dp[1][i] = Math.max(dp[0][i-1],dp[0][i-2])+board[1][i];
            }
            answer = Math.max(dp[0][n-1],dp[1][n-1]);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
