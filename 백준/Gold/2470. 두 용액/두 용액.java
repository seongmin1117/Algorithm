import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    두 용액
    1.문제
        서로 다른 두 용액 더해서 0에 가장 가까운 용액 오름차순으로 출력
    2.조건
        -10억 ~10, 모든 수는 다르고, 전부 양수이거나 음수일 수 있음
        전체 용액의 수는 최대 10만
    3.접근
        최대 10만개기 때문에 O(NlogN)으로 풀어야 한다.

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int minX = 0;
        int minY = 0;
        int[] twoSum = new int[n-1];
        for (int i=0; i<n-1; i++){
            twoSum[i] = arr[i] + arr[i+1];
            if(Math.abs(twoSum[i])<min){
                min = Math.abs(twoSum[i]);
                minX = arr[i];
                minY = arr[i+1];
            };
        }
            int start = 0;
            int end = n-1;
            while (start<end){
                int target = arr[start]+arr[end];
                if(Math.abs(target)<min){
                    min = Math.abs(target);
                    minX = arr[start];
                    minY = arr[end];
                }
                if(target>0){
                    end--;
                }else if(target<0){
                    start++;
                }else {
                    System.out.println(arr[start]+" "+arr[end]);
                    return;
                }

            }
        System.out.println(minX+" "+minY);

    }
}
