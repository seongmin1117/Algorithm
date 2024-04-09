import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
    숨바꼭질
    x-1 , x+1 , 2*x 가능
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] times = new int[100001];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{n,0});
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int time = cur[1];
            if(x==k){
                System.out.println(time);
                return;
            }
            if (x-1>=0 && times[x-1]==0) {
                q.add(new int[]{x-1,time+1});
                times[x-1] = time+1;
            }
            if(x+1<=100000 && times[x+1]==0) {
                q.add(new int[]{x+1,time+1});
                times[x+1] = time+1;
            }
            if (2*x<=100000 && times[2*x]==0) {
                q.add(new int[]{2*x,time+1});
                times[2*x] = time+1;
            }
        }
    }
}
