import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] graph = new int[n + 1][n + 1];

        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            graph[from][to] = cost;
            graph[to][from] = cost;
        }

        int[][] distanceFrom = new int[3][n + 1];
        for (int[] dist : distanceFrom) {
            Arrays.fill(dist, Integer.MAX_VALUE);
        }

        int[] startPoints = {s, a, b};
        for (int idx = 0; idx < 3; idx++) {
            int[] dist = distanceFrom[idx];
            PriorityQueue<int[]> queue = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
            queue.add(new int[]{startPoints[idx], 0});
            dist[startPoints[idx]] = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int currentNode = current[0];
                int currentCost = current[1];

                for (int next = 1; next <= n; next++) {
                    if (graph[currentNode][next] == 0) continue;

                    int newCost = currentCost + graph[currentNode][next];
                    if (dist[next] > newCost) {
                        dist[next] = newCost;
                        queue.add(new int[]{next, newCost});
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int combinedCost = 0;
            for (int[] dist : distanceFrom) {
                combinedCost += dist[i];
            }
            min = Math.min(min, combinedCost);
        }

        return min;
    }
}
