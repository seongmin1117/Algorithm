import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Map<Long, Long> map1 = new HashMap<>();
        Map<Long, Long> map2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long temp = 0;
            for (int j= i; j < n; j++){
                temp += arr1[j];
                map1.put(temp,map1.getOrDefault(temp,0L)+1);
            }
        }

        for (int i = 0; i < m; i++) {
            long temp = 0;
            for (int j=i; j < m; j++){
                temp += arr2[j];
                map2.put(temp,map2.getOrDefault(temp,0L)+1);
            }
        }
        long sum = 0;
        for (Long l : map1.keySet()) {
            long temp = T -l;
            long cnt = map2.getOrDefault(temp, Long.valueOf(0));
            sum += map1.get(l)*cnt;
        }

        System.out.println(sum);
    }
}
