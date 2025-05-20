import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;

        for (int indexToRemove = 0; indexToRemove < wires.length; indexToRemove++) {
            List<List<Integer>> connectionMap = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                connectionMap.add(new ArrayList<>());
            }

            for (int i = 0; i < wires.length; i++) {
                if (i == indexToRemove) continue;
                int towerA = wires[i][0];
                int towerB = wires[i][1];
                connectionMap.get(towerA).add(towerB);
                connectionMap.get(towerB).add(towerA);
            }

            boolean[] visited = new boolean[n + 1];
            int networkSize = bfs(1, visited, connectionMap);
            int otherNetworkSize = n - networkSize;
            int difference = Math.abs(networkSize - otherNetworkSize);

            min = Math.min(min, difference);
        }

        return min;
    }

    private int bfs(int start, boolean[] visited, List<List<Integer>> map) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : map.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    count++;
                }
            }
        }

        return count;
    }
}
