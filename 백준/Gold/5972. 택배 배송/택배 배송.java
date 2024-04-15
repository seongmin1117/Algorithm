import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    택배 배송
    노드 1~50000, 엣지 1~50000 소 0~1000
    같은 곳을 이은 곳은 없고,  A -> B  한가지 이상 길이 있을 수 있음
    1에서 N까지 최소비용으로 다익스트라 사용
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        HashMap<Integer, List<Node>> graph  = new HashMap<>();
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.putIfAbsent(u,new ArrayList<>());
            graph.putIfAbsent(v,new ArrayList<>());
            graph.get(u).add(new Node(v,w));
            graph.get(v).add(new Node(u,w));
        }
        int[] dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        pq.add(new Node(1,0));
        dis[1]  = 0;
        while (!pq.isEmpty()){
            Node cur = pq.poll();
            if (cur.w > dis[cur.v]) continue;
            for (Node next : graph.get(cur.v)){
                int next_dis = dis[cur.v] + next.w;
                if (next_dis >= dis[next.v]) continue;
                dis[next.v] = next_dis;
                pq.add(new Node(next.v, next_dis));
            }
        }
        System.out.println(dis[n]);
    }

    static class Node implements Comparable<Node>{
        int v;
        int w;
        private Node(int v, int w){
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Node o){
            return this.w- o.w;
        }
    }
}
