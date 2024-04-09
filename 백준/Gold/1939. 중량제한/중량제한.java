import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    중량제한

    N개의 섬 , M개의 다리,  A번 섬과 B번 섬사이의  중량제한이 C인 다리 , 마지막 줄은 공장이 위치해있는 섬의 번호
    n은 최대 1만 ,  m은 최대10만 , C는 최대 10억 (이분탐색 ? )
    서로 같은 두섬 사이에 여러개의 다리가 존재 가능, 모든 다리는 양방향 (중복이면 최댓값 사용 -> Set or 우선순위큐)

    한번의 이동에서 옮길 수 있는  -> 두 섬이 연결될 때 (union or BFS+방문체크 )
    물품들의 중량의 최댓값 구하기 -> 중량제한을 넘지 않는 것 중 최대 (우선순위 큐, 이분탐색)

    노드가 최대 1만이라 연결그래프로 만들려면 1억개가 되므로 메모리,시간초과 (배열사용 x -> 해시맵 or 리스트)
    
    간선은 최대 10만 -> 간선을 이용해서 끝내야한다. (간선 사용하는 알고리즘)

    일단 우선순위큐에 edge를 무게가 큰 순으로 정렬, 하나씩 빼면서 edge가 연결 되어 있는지 확인
    연결 X-> b와 연결되어있는 모든 노드를 a와 연결시키기 
    그 후 두 섬이 연결되어있는지 확인 -> 연결 되면 출력 (항상 답이 존재하므로 현재 무게가 최댓값)

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> pq = new PriorityQueue<>(((o1, o2) -> o2.weight- o1.weight));

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Edge(a,b,weight));
        }
        
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[] union = new int[10001];

        for (int i=1; i<=n; i++){
            union[i] = i; // 초기값
        }

        while (!pq.isEmpty()){
            Edge edge = pq.poll(); // 현재 무게가 최대인 간선
            if (union[edge.a] != union[edge.b]){ // 두 섬이 연결 되어있지 않다면 연결시키기
                int temp = union[edge.b];
                for (int i=1; i<=n; i++){ // 모든 노드에 대해
                    if(union[i] == temp){ // b랑 연결되어 있으면
                        union[i] = union[edge.a]; // a랑 연결시킨다.
                    }
                }
            }
            if (union[x]==union[y]){ // 문제에서 주어진 섬이 연결되는 순간이 항상 최댓값
                System.out.println(edge.weight);
                return;
            }
        }

    }
    static class Edge{
        int a;
        int b;
        int weight;
        
        Edge(int a, int b, int weight){
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
    }
}
