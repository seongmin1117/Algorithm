import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    보석도둑
    1.문제
       가방에는 최대 한개의 보석을 담을 수 있다.
       훔칠 수 있는 보석의 최대가격 구하기

       -> 가방의 최대무게가 x일때 제일 비싼 보석 찾기
    2.조건
        1 ~ 보석,가방 ~ 300,000
        0 ~ 보석의 무게,가격 ~ 1,000,000
        1 ~ 가방의 최대 무게 ~ 100,000,000
        출력값 long (최대 가격이 겁나 큼)
    3.접근
        가장 비싼 보석(값이 같으면 무거운 보석)이 들어갈 수 있는 가장 작은 가방 찾기 (그리디)
        보석을 가격이 제일 크고 무게가 제일 작은 순으로 정렬 (우선순위 큐)
        가방을 무게가 작은 순으로 정렬 (정렬)
        넣을 보석이 없을 때까지 (큐가 빌때까지) , or 가방이 다 찰때까지
        첫번째 가방부터 첫번째 보석을 넣을 수 있는지 확인 -> 넣었으면 다음 가방

        --시간초과--
        가방이 중복될 수 있어서 이분탐색말고 다른 자료구조를 사용해서 시간을 줄여야하나?
        우선순위큐를 쓰는게 더 빠른가 ?..
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Gem> pq = new PriorityQueue<>(((o1, o2) -> {
            //무게가 같다면 비싼순
            if(o1.weight==o2.weight){
                return (int)(o2.price - o1.price);
            }
            // 가벼운 순
            return  o1.weight-o2.weight;
        }));
        PriorityQueue<Gem> pq2 = new PriorityQueue<>(((o1, o2) -> (int)(o2.price - o1.price))); //비싼 순
        PriorityQueue<Integer> bags = new PriorityQueue<>(); // 가벼운순
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //보석 수
        int k = Integer.parseInt(st.nextToken()); //가방 수

        int min_weight = Integer.MAX_VALUE; // 보석의 최소 무게
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            long price = Long.parseLong(st.nextToken());
            pq.add(new Gem(weight,price));
            min_weight = Math.min(weight,min_weight);
        }
        int max_weight = -1; // 가방의 최대 무게
        for(int i=0; i<k; i++){
            int weight = Integer.parseInt(br.readLine());
            if(weight<min_weight) continue; // 보석의 최소 무게보다 작으면 버리기
            bags.add(weight);
            max_weight = Math.max(weight,max_weight);
        }
        long answer = 0;
        while (!bags.isEmpty()){
            int weight = bags.poll();
            while (!pq.isEmpty()&& pq.peek().weight<=weight){
                pq2.add(pq.poll());
            }
            if(pq2.isEmpty()) continue;
            answer += pq2.poll().price;

        }
        System.out.println(answer);

    }
}
class Gem {
    int weight;
    long price;

    public Gem(int weight, long price){
        this.weight = weight;
        this.price = price;
    }
}
