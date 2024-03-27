import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};
        int[] dr = {1,0,-1,0};
        int[] dc = {0,-1,0,1};
        for(int t=0; t<5; t++){
            int[][] board = new int[5][5];
            boolean chk = false;
            List<int[]> list = new ArrayList<>();
            for(int i=0; i<5; i++){
                char[] ch  = places[t][i].toCharArray();
                for(int j=0; j<5; j++){
                    if(ch[j]=='P'){
                        board[i][j] = -1;
                        list.add(new int[]{i,j,1}); //r,c,거리
                    }
                    if(ch[j]=='O'){
                        board[i][j]=0;
                    }
                    if(ch[j]=='X'){
                        board[i][j]=1;
                    }
                }
            }
            for(int[] arr : list){
                Queue<int[]> q = new LinkedList<>();
                boolean[][] visited = new boolean[5][5];
                q.add(arr);
                visited[arr[0]][arr[1]] = true;
            while(!q.isEmpty()){
                int[] cur = q.poll();
                int curR = cur[0];
                int curC = cur[1];
                int distance = cur[2];
                if(distance>2) break;
                for(int d=0; d<4; d++){
                    int nr = curR + dr[d];
                    int nc = curC + dc[d];
                    if(nr<0||nc<0||nr>=5||nc>=5 ||board[nr][nc]==1 ||visited[nr][nc]) continue;
                        visited[nr][nc] = true;
                    if(board[nr][nc]==-1){
                        System.out.print("nr"+nr);
                        System.out.println("nc"+nc);
                        answer[t] = 0;
                        chk = true;
                        break;
                    }
                    q.add(new int[] {nr,nc,distance+1});
                }
                if(chk) break;
            }
            }
        }
        return answer;
    }
}