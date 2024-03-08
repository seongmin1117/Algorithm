import java.util.*;
import java.lang.*;
class Solution {
    public int solution(int k, int[][] dungeons) {
        int max = Integer.MIN_VALUE;
        int n = dungeons.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        dfs(0,n,res,list,visited);
        
        for(int i=0; i<res.size(); i++){
            List<Integer> curRes = res.get(i);
            int hp = k;
            int count = 0;
            for(Integer cur : curRes){
                int min = dungeons[cur][0];
                int use = dungeons[cur][1];
                if(hp>=min && hp-use>=0){
                    hp -= use;
                    count++;
                }
            }
            max = Math.max(max,count);
        }
        return max;
    }
    private void dfs(int k,int n, List<List<Integer>> res, List<Integer> list, boolean[] visited){
        if(k==n){
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            res.add(temp);
            return;
        }
        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            list.add(i);
            visited[i] = true;
            dfs(k+1,n,res,list,visited);
            visited[i] = false;
            list.remove(k);
        }
    }
}