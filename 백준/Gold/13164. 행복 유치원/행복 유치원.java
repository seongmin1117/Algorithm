import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    /*
    행복 유치원
    그리디

     N명을 키순서로 줄세우고 총 K개의 조로 나눈 ( 적어도 한명 존재해야하고, 서로 인접해야한다. 인원수는 달라도됨)
     티셔츠 비용은 조별로 키가 가장 큰 원생과 가장 작은 원생의 차이
     K개의 조 티셔츠 비용 최소 구하기

     오름차순 된 입력 , 부분 차

       가장 큰 갭을 k-1개 지우고 남은게 정답
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
        
        for (int i=0; i<n-1; i++){
            int gap = arr[i+1] - arr[i];
            pq.add(gap);
        }
        int temp = k-1;
        while (temp-- >0){
            pq.poll();
        }
        int answer = 0;
        while (!pq.isEmpty()){
            answer += pq.poll();
        }
        System.out.println(answer);






    }
}
