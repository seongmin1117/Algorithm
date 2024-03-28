import java.util.*;
class Solution {
    static int n;
    static boolean isValid(int r1, int c1, int r2, int c2){
        return r1>=0 && c1>=0 && r2>=0 && c2>=0 && r1<n && r2<n && c1<n && c2<n;
    }
    public int solution(int[][] board) {
        n = board.length;
        int[] dr = {1,0,-1,0};
        int[] dc = {0,-1,0,1};
        boolean[][] visited = new boolean[2*n][2*n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,0,1,0}); // r1,c1,r2,c2,distance
        visited[0][1] = true; //두 좌표의 합을 방문 배열에 저장
        int[][] rotateR = {
    {1, 0, 0, 0},
    {-1, 0, 0, 0},
    {0, 0, 1, 0},
    {0, 0, -1, 0}
};
        int[][] rotateC = {
            {0, 1, 0, 0},
             {0, -1, 0, 0},
            {0, 0, 0, 1},
    {0, 0, 0, -1}
        };
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r1 = cur[0]; int c1 = cur[1];
            int r2 = cur[2]; int c2 = cur[3];
            int distance = cur[4];
            for(int d=0; d<4; d++){
                int nr1 = r1+dr[d]; int nc1 = c1+dc[d];
                int nr2 = r2+dr[d]; int nc2 = c2+dc[d];
        if(!isValid(nr1,nc1,nr2,nc2) || board[nr1][nc1]==1 || board[nr2][nc2]==1) continue;
                if(visited[nr1+nr2][nc1+nc2]) continue;
                if( (nr1==n-1 && nc1==n-1) || (nr2==n-1 && nc2==n-1) ){
                    return distance+1;
                }
                visited[nr1+nr2][nc1+nc2] = true;
                q.add(new int[] {nr1,nc1,nr2,nc2,distance+1});
            }
            int[] rot = {1,-1};
            //행이 같으면 가로, 열이 같으면 세로
            if(r1==r2){
                for(int d=0; d<2; d++){
                    //왼쪽만 시계 or 반시계
                    int nr1 = r1 + rot[d];
                    int nc1 = c2;
                    int nr2 = r2;
                    int nc2 = c2;
            if(!isValid(nr1,nc1,nr2,nc2)) continue;
                    if(board[nr1][c1]==1 || board[nr1][c2]==1) continue;
                    if(visited[nr1+nr2][nc1+nc2]) continue;
                    if( (nr1==n-1 && nc1==n-1) || (nr2==n-1 && nc2==n-1) ){
                    return distance+1;
                }
                    visited[nr1+nr2][nc1+nc2] = true; 
                q.add(new int[] {nr1,nc1,nr2,nc2,distance+1});
                }
                
                for(int d=0; d<2; d++){
                    //오른쪽만 시계 or 반시계
                    int nr1 = r1;
                    int nc1 = c1;
                    int nr2 = r2 + rot[d];
                    int nc2 = c1;
                 if(!isValid(nr1,nc1,nr2,nc2)) continue;
               if(board[nr2][c1]==1 || board[nr2][c2]==1) continue;
                    if(visited[nr1+nr2][nc1+nc2]) continue;
                    if( (nr1==n-1 && nc1==n-1) || (nr2==n-1 && nc2==n-1) ){
                    return distance+1;
                }
                    visited[nr1+nr2][nc1+nc2] = true; 
                q.add(new int[] {nr1,nc1,nr2,nc2,distance+1});
                }
            } //열이 같을 때
            else if(c1==c2) {
                //왼쪽
                for(int d=0; d<2; d++){
                    int nr1 = r2 ;
                    int nc1 = c1 + rot[d];
                    int nr2 = r2;
                    int nc2 = c2;
            if(!isValid(nr1,nc1,nr2,nc2)) continue;
                    if(board[r1][nc1]==1 || board[r2][nc1]==1) continue;
                    if(visited[nr1+nr2][nc1+nc2]) continue;
                    if( (nr1==n-1 && nc1==n-1) || (nr2==n-1 && nc2==n-1) ){
                    return distance+1;
                }
                    visited[nr1+nr2][nc1+nc2] = true; 
                q.add(new int[] {nr1,nc1,nr2,nc2,distance+1});
                }
                //오른쪽
                for(int d=0; d<2; d++){
                    int nr1 = r1;
                    int nc1 = c1;
                    int nr2 = r1 ;
                    int nc2 = c2 + rot[d];
            if(!isValid(nr1,nc1,nr2,nc2)) continue;
                    if(board[r1][nc2]==1 || board[r2][nc2]==1) continue;
                    
                    if(visited[nr1+nr2][nc1+nc2]) continue;
                    if( (nr1==n-1 && nc1==n-1) || (nr2==n-1 && nc2==n-1) ){
                    return distance+1;
                }
                    visited[nr1+nr2][nc1+nc2] = true; 
                q.add(new int[] {nr1,nc1,nr2,nc2,distance+1});
                }
            }
        }
        return 0;
    }
}