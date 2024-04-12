import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    동전 1
    DP
    동전을 적당히 사용해서 그 가치의 합이 K가 되는 경우의 수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dp = new int[k+1];
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1; // 자기 자신으로 만들 수 있는 경우
        for (int coin : arr){ //동전 마다
            for (int i=coin; i<=k; i++){ // 현재 동전 크기부터 K까지
                dp[i] += dp[i-coin]; // 저장된 값에 현재 동전이 사용되는 수 만큼 더하기
            }
        }
        System.out.println(dp[k]);
    }
}
