class Solution {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n+1][n+1];

        for (int[] result : results) {
            int win = result[0];
            int lose = result[1];
            graph[win][lose] = 1;
            graph[lose][win] = -1;
        }

        for (int mid = 1; mid <= n; mid++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    int result = (graph[a][mid] + graph[mid][b]) / 2;
                    if(result == 0) continue;
                    graph[a][b] = result;                        
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != 0) count++;
            }
            if (count == n-1) answer++;
        }

        return answer;
    }
}
