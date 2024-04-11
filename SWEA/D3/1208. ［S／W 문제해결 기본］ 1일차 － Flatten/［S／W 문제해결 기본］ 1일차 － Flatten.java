import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
            int[] arr = new int[100];
            for (int i=0; i<100; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            while (n-- >0){
                arr[99]--;
                arr[0]++;
                Arrays.sort(arr);
            }
            int answer = arr[99]-arr[0];
            System.out.println("#"+count+" "+answer);
        }
    }
}
