import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        int count = 0;
        while (T-->0){
            count ++;
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int answer = 0;
            for (int i=2; i<n-2; i++){
                int cur = arr[i];
                int pre = Math.max(arr[i-2],arr[i-1]);
                int next = Math.max(arr[i+1],arr[i+2]);
                int max = Math.max(next,pre);
                if (cur>max){
                    answer += cur-max;
                }
            }
            System.out.println("#"+count+" "+answer);
        }
    }
}
