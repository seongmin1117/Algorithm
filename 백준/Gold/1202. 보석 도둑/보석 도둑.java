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
        가장 작은 가방에 들어갈 수 있는 가장 비싼 보석 찾기(그리디)
        보석을 가격이 제일 크고 무게가 제일 작은 순으로 정렬 (우선순위 큐)
        가방을 무게가 작은 순으로 정렬 (우선순위 큐)
        넣을 보석이 없을 때까지 (큐가 빌때까지) or 가방이 다 찰때까지
        첫번째 가방부터 들어갈 수 있는 보석을 새로운 pq에 넣고 돌리기

        --시간초과--
        가방이 중복될 수 있어서 이분탐색말고 다른 자료구조를 사용해서 시간을 줄여야하나?
        우선순위큐를 쓰는게 더 빠른가 ?..
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Gem> light = new PriorityQueue<>(((o1, o2) -> o1.weight-o2.weight)); // 무게 내림차순
        // 현재 가방에 들어갈 수 있는 보석중 비싼순서
        PriorityQueue<Gem> expensive = new PriorityQueue<>(((o1, o2) -> (int)(o2.price - o1.price)));
        PriorityQueue<Integer> bags = new PriorityQueue<>(); // 가방의 최대 크기가 작은순
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //보석 수
        int k = Integer.parseInt(st.nextToken()); //가방 수

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            long price = Long.parseLong(st.nextToken());
            light.add(new Gem(weight,price)); // 보석 무게 내림차순
        }

        for(int i=0; i<k; i++){
            int weight = Integer.parseInt(br.readLine());
            bags.add(weight); // 가방 크기 내림차순
        }
        long answer = 0; // 출력값 long
        while (!bags.isEmpty()){ //가방이 빌때까지
            int weight = bags.poll();
            // 현재 가방의 무게보다 작은 보석들을 비싼순으로 정렬
            while (!light.isEmpty()&& light.peek().weight<=weight){
                expensive.add(light.poll());
            }
            // 가방에 들어갈 보석이 없으면 넘어가기
            if(expensive.isEmpty()) continue;
            answer += expensive.poll().price;
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
