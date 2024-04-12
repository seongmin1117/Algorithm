import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    파티
    1. 모든 노드에 대해서 다익스트라를 다 돌리니까 통과는 됐는데 최적화가 필요해보임

    2. 그래프를 거꾸로 뒤집어서 다익스트라 두 번만 돌리면 된다는데 이게 뭔 소린지 공부중...
        2-1 기존 그래프로 파티장소에서 각 출발지까지 도착하는데 걸리는 최단 거리 구하기 ( 다익스트라 1번 사용)
        2-2 그래프를 뒤집으면, 출발지 -> 파티장소 가 파티장소 -> 출발지가 된다.
            그러면 각 마을마다 다익스트라를 사용할 필요없이 또 파티장소에서 다익스트라를 사용하면 된다. !

     출발지가 여러개인 다익스트라에서 들려야하는 도착지가 하나로 정해져있 을 때, 다익스트라를 최소로 사용해서 풀 수 있구나 ! ! !
     다익스트라 응용문제가 이런식이군  ! ! ! !
     */
    static int n,x,max;
    static List<List<Node>> graph = new ArrayList<>();
    static List<List<Node>> reverse = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for (int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }

        while (m-- >0){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to,cost)); // 기존 그래프
            reverse.get(to).add(new Node(from,cost)); // 거꾸로
        }
        
        int[] d1 = dijkstra(graph); // x -> 출발지
        int[] d2 = dijkstra(reverse); // 출발지 -> x
        for (int i=1; i<=n; i++){
            max = Math.max(max, d1[i]+d2[i]);
        }
        System.out.println(max);
    }
    static int[] dijkstra(List<List<Node>> graph){
        int[] dis = new int[n+1]; // 최단거리 저장
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[x] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost); //최소 비용순
        pq.add(new Node(x,0));
        
        while (!pq.isEmpty()){
            Node cur = pq.poll();
            if (cur.cost > dis[cur.to]) continue;
            for (Node next : graph.get(cur.to)) {
                if (next.cost+dis[cur.to] >= dis[next.to]) continue;
                dis[next.to] = dis[cur.to] + next.cost;
                pq.add(new Node(next.to,dis[next.to]));
            }
        }
        return dis;
    }
    static class Node{
        int to;
        int cost;
        private Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }

}
