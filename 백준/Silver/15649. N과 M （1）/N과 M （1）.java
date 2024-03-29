import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n+1];
        bt(0);
        System.out.println(sb);
    }
    static void bt(int k){
        if(k==m){
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i=1; i<=n; i++){
            if(visited[i]) continue;
            arr[k] = i;
            visited[i] = true;
            bt(k+1);
            visited[i] = false;
        }
    }
}
