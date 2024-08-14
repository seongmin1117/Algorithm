import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 유니온파인드
public class Main {
    static int G,P,result;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        // 부모배열 생성 후 초기화
        parent = new int[G+1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }

        for (int i=0; i<P; i++) {
            int gate = Integer.parseInt(br.readLine()); //입력 받기

            int availableGate = find(gate); // 도킹할 수있는 가장 큰 게이트 찾기

            if (availableGate == 0){ // 도킹 할 수 없으면 종료
                break;
            }
            // 도킹한 후 그 게이트는 이용할 수 없으므로 그 다음 큰 게이트와 도킹
            union(availableGate, availableGate-1);

            result++; // 도킹 성공 -> 카운팅
        }
        System.out.println(result);
    }
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]); // 경로 압축
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[x] = y; // 유니온 처리
        }
    }
}
