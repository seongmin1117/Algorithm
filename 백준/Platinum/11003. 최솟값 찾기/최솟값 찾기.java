import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Deque<int[]> deq = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());

        for (int i=1; i<n+1; i++){
            int cur = Integer.parseInt(st.nextToken());
            // 값 비교 뒤부터 , 인덱스 비교 앞부터
            while (!deq.isEmpty() && deq.peekLast()[1] >= cur) {
                deq.removeLast();
            }
            deq.addLast(new int[] {i,cur});
            if (!deq.isEmpty() && deq.peekFirst()[0] <= i-l) deq.removeFirst();
            if (!deq.isEmpty()) bw.write(deq.peekFirst()[1]+" ");
        }
        bw.flush();
        bw.close();
    }
}
