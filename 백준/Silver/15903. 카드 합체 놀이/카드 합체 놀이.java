import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    /*
    카드 합체 놀이
    1.문제
        x번 카드와 y번 카드를 더한 값을 x,y에 덮어씌우기
        m번 반복 후 모든 카드의 합이 최소인 것 찾기
    2.접근
        우선순위 큐로 두개 빼서 더하고 그 값 두 번 넣고 하면 될 듯
    3.조건
        2<= N<= 1000 , 0<= M <= 15*N , 1<= a<= 1,000,000
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        while (n-- >0){
            pq.add(Long.parseLong(st.nextToken()));
        }
        while (m-- >0){
            long x =pq.poll();
            long y =pq.poll();
            pq.add(x+y);
            pq.add(x+y);

        }
        long sum =0;
        while (!pq.isEmpty()){
            sum += pq.poll();
        }
        System.out.println(sum);
    }
}
