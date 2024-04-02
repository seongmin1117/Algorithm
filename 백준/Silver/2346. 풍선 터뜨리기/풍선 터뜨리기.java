import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    /*
    풍선터뜨리기
    1번부터 N번까지 풍선이 '원형'으로 놓여 있다. (1번 왼쪽이 N  N번 오른쪽이 1)
    풍선안에 있는 값만큼 이동, 이미 터진 풍선은 넘어가기
    1 <= N <= 1000
    환형큐 ? 덱 ?
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            deque.add(i);
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            int cur = deque.pollFirst();
            sb.append(cur).append(" ");
            int idx = arr[cur];
            // 양수일 때 오른쪽 이동
            if(idx>0){ // 먼저 감소 후 
                while (--idx >0 && !deque.isEmpty()){
                    deque.addLast(deque.pollFirst());
                }
            }
            // 음수 일 때 왼쪽 이동
            else{
                while ((idx++ <0 && !deque.isEmpty())){
                    deque.addFirst(deque.pollLast());
                }

            }
        }
        System.out.println(sb);
    }
}
