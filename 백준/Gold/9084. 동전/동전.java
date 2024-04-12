import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    동전
    3번이랑 아예 똑같
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- >0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m+1];
            dp[0] = 1;
            for (int i=0; i<n; i++){
                for (int j=arr[i]; j<=m; j++){
                    dp[j] += dp[j- arr[i]];
                }
            }
            sb.append(dp[m]).append("\n");
        }
        System.out.println(sb);
    }
}
