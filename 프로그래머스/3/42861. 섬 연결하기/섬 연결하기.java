import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int answer = 0;
        int count = 0;
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        for (int[] edge : costs) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];

            if (find(parent, a) != find(parent, b)) {
                union(parent, a, b);
                answer += cost;
                count++;
                if (count == n-1) break;
            }
        }

        return answer;
    }

    private int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }

    private void union(int[] parent, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);
        if (pa < pb) parent[pb] = pa;
        else parent[pa] = pb;
    }
}
