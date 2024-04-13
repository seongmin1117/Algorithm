import java.util.*;
class Solution {
    int max;
    boolean[] visited;
    int solution(int[] info, int[][] edges) {
        int n = info.length;
        visited = new boolean[n];
        visited[0] = true;
        backtrack(1,0,edges,info);
        return max;
    }
    void backtrack(int sheep, int wolf, int[][] edges, int[] info){
        if(sheep<=wolf) return;
        max = (sheep > max ? sheep : max);
        for(int i=0; i<edges.length; i++){
            int parent = edges[i][0];
            int child = edges[i][1];
            // 부모는 방문했고 자식은 방문하지 않았으면 가능
            if(visited[parent] && !visited[child]){
                //양이면 양+1 하고 백트래킹
                if(info[child]==0){
                    sheep++;
                    visited[child] =true;
                    backtrack(sheep,wolf,edges,info);
                    visited[child] =false;
                    sheep--;
                } else {
                    wolf++;
                    visited[child] =true;
                    backtrack(sheep,wolf,edges,info);
                    visited[child] =false;
                    wolf--;
                }
            }
        }
    }
}