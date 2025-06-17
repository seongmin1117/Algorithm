public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1_000_000_007;
        int[][] dp = new int[n][m];

        boolean[][] isPuddle = new boolean[n][m];
        for (int[] p : puddles) {
            int x = p[0] - 1;
            int y = p[1] - 1;
            isPuddle[y][x] = true;
        }

        dp[0][0] = 1;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (isPuddle[y][x]) {
                    dp[y][x] = 0;
                    continue;
                }
                
                if (y > 0) dp[y][x] = (dp[y][x] + dp[y - 1][x]) % MOD;
                if (x > 0) dp[y][x] = (dp[y][x] + dp[y][x - 1]) % MOD;
            }
        }

        return dp[n - 1][m - 1];
    }
}
