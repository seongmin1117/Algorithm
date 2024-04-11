import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    파티

    다익스트라
     */
    static int n,x,max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        HashMap<Integer, List<Edge>> map = new HashMap<>();
        while (m-- >0){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map.putIfAbsent(from,new ArrayList<>());
            map.get(from).add(new Edge(to,cost));
        }
        int[][] dis = new int[n+1][n+1];
        for (int i=0; i<n+1; i++){
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        for (int start: map.keySet()) { // start에서 모든 마을까지의 최단 거리
            List<Edge> edges = map.get(start);
            dis[start][start] = 0;
            PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost -o2.cost);
            for (Edge edge : edges) { // n번과 연결된 다리를 거리 갱신 후 pq 에 넣는다.
                dis[start][edge.to] = edge.cost;
                pq.add(edge);
            }
            while (!pq.isEmpty()){
                Edge cur = pq.poll();
                map.get(cur.to);
                for (Edge next : map.get(cur.to)) {
                    if (next.cost+ dis[start][cur.to] >= dis[start][next.to]) continue;
                    dis[start][next.to] = dis[start][cur.to]+next.cost;
                    pq.add(next);
                }
            }
        }
        for (int i=1; i<=n; i++){
            int d = dis[i][x] + dis[x][i];
            max = Math.max(d,max);
        }
        System.out.println(max);


    }
    static class Edge{
        int to;
        int cost;
        private Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
}
