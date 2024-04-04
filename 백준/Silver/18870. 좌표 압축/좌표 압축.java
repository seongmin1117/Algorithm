import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int[] base = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            x[i] = Integer.parseInt(st.nextToken());
            base[i] = x[i];
        }
        // 1. 정렬한 배열 생성
        Arrays.sort(x);
        // 2. 중복제거
        List<Integer> list = new ArrayList<>();
        list.add(x[0]);
        for (int i=1; i<n; i++){
            if (x[i-1] != x[i]){
                list.add(x[i]);
            }
        }
        // 3. 이분탐색
        for (int i=0; i<n; i++){
            int target = base[i];
            int start = 0;
            int end = list.size();
            while (start<end){
                int mid = (start+end)/2;
                if (list.get(mid)==target){
                    bw.write(mid+" ");
                    break;
                }else if(list.get(mid)>target){
                    end = mid;
                }else if(list.get(mid)<target){
                    start=mid+1;
                }
            }
        }
        bw.flush();

    }
}
