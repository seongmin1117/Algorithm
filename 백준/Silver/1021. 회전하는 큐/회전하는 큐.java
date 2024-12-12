import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = new int[m];
        int count = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        for (int i = 0; i < m; i++) {
            int x = num[i];
            int size = q.size();
            int index = q.indexOf(x);

            if (q.indexOf(x) <= size / 2) { //앞에서 더 가까운 수인 경우
                for (int j = 0; j < index; j++) {
                    int y = q.pollFirst();
                    q.addLast(y);
                    count++;
                }
            } else { //뒤에서 더 가까운 수인 경우
                for (int j = 0; j < size - index; j++) {
                    int y = q.pollLast();
                    q.addFirst(y);
                    count++;
                }
            }
            q.poll();
        }
        System.out.println(count);
    }
}