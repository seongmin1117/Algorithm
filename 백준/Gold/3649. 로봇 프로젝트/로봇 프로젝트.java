import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    /*
    로봇 프로젝트

    이분탐색의 느낌이 온다
    구멍에 넣을 두 조각의 길이의 합 = 구멍의 너비
    막을 수 없으면 danger 출력
    있으면 yes l1 l2 출력

    1센치 = 1000만나노 , 구멍크기 최대 2억나노미터

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line= br.readLine())!=null){
            StringBuilder sb = new StringBuilder();
            int target = Integer.parseInt(line)  *10000000;
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            for (int i=0; i<n; i++){
                int l = Integer.parseInt(br.readLine());
                arr[i] =l;
            }
            Arrays.sort(arr);
            int start = 0;
            int end = n-1;
            boolean isValid = false;
            while (start<end){
                int mid  = arr[start]+arr[end];
                if (mid>target){
                    end--;
                } else if(mid <target){
                    start++;
                } else {
                    sb.append("yes ").append(arr[start]).append(" ").append(arr[end]);
                    isValid = true;
                    break;
                }
            }
            if (!isValid){
                sb.append("danger");
            }
            System.out.println(sb);
           
        }
    }
}
