import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    세 용액
    1.문제
        세 용액을 더해서 0가 가까운 용액 찾기
    2.조건
        용액의 수 N : 3~5000
        N개의 용액은 모두 다르고 -10억~ +10억 이므로 long 사용
    3.접근
        두 용액과 비슷하다. 용액의 수가 10만에서 5천으로 줄었지만 3개의 합이기 때문에
        O(N^3)은 불가능하고 O(N^2logN)부터 가능하다.
        세 수의합을 두수의 합처럼 풀면 ?
        입력받은 수를 정렬하고 이중 for문을 돌면서 부분합을 만들고 이분탐색?
        -- 5000*5000이 2500만이라 배열 메모리가 너무 많이 사용됨

        입력값중 하나를 고르고, 나머지 입력값 두개를 더한게 그 입력값과 가까울 때까지 탐색
        두 용액은 0가 가까운거지만 이건 입력값 중 하나와 가깝게 !
        
        -> 39% 실패 입력을 굳이 long으로 받아야하나 ? 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long[] arr = new long[n];
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        long x = 0; long y = 0; long z = 0;

        for(int mid=1; mid<n-1; mid++){
            int start = 0;
            int end = n-1;
            while (start<mid && mid<end ){
                long gap = arr[start]+arr[mid]+arr[end]; // 세 수의 합 ( start+end  mid 의 차이)
                if(min > Math.abs(gap)){
                    min = Math.abs(gap);
                    x = arr[start]; y = arr[mid]; z = arr[end];
                }
                if(gap<0){
                    start++;
                }else if(gap>0){
                    end--;
                } else { // 같으면 바로 출력
                    sb.append(x).append(" ").append(y).append(" ").append(z);
                    System.out.println(sb);
                    return;
                }
            }
        }
        sb.append(x).append(" ").append(y).append(" ").append(z);
        System.out.println(sb);
    }
}
