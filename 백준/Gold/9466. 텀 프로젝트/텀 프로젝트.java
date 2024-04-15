import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int chk,count;
    static boolean[] visited,team;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[n+1];
            visited  = new boolean[n+1];
            team  = new boolean[n+1];
            count = 0;
            for (int i=1; i<=n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] == i) {
                    team[i] = true; // 자신과 팀인 경우 체크
                    count++;
                }
            }
            for (int i=1; i<=n; i++){
                if (team[i]) continue; //이미 팀인 경우 넘어가기
                dfs(i);
            }
            sb.append(n-count).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start){
        int next = arr[start];

        if (team[start]) return;

        if (visited[start]){
            team[start] = true;
            count++;
        }

        visited[start] = true;
        dfs(next);
        team[start] = true;
        visited[start] = false;

    }
}
