import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    전깃줄
        남아있는 전깃줄이 서로 교차하지 않게 제거해야하는 전깃줄의 최소 개수

        LIS : 가장 긴 증가하는 부분 수열
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Pair> list = new ArrayList<>();
        int[] dp = new int[n];
        Arrays.fill(dp,501);
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Pair(x,y));
        }
        Collections.sort(list,((o1, o2) -> o1.y-o2.y));
        dp[0] = list.get(0).x;
        int max = 0;
        for (int i=1; i<n; i++){
            int cur = list.get(i).x;
            for (int j=0; j<n; j++){
                if (cur<dp[j]){
                    dp[j] = cur;
                    max = Math.max(max,j);
                    break;
                }
            }
        }
        System.out.println(n-1-max);

    }
    static class Pair{
        int x;
        int y;
        private Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
