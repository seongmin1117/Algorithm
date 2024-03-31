import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            q.add(i);
            visited[i] = true;
            count++;
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int nxt=0; nxt<n; nxt++){
                    if(nxt==cur || visited[nxt] || computers[cur][nxt]==0) continue;
                    visited[nxt] = true;
                    q.add(nxt);
                }
            }
        }
        return count;
    }
}