import java.util.*;
class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dis = Math.abs(x-r) + Math.abs(y-c);
        if(k<dis || (k%2 != dis%2) ){
            return "impossible";
        }
        int a = k-dis; //추가 이동 거리  du 혹은 lr
        int[] dir = new int[4]; 
        // 출발지가 더 아래쪽이면 그만큼 가야하는 u 추가
        if(x-r>0){
            dir[3] += x-r;
        } else { // 위쪽이면 d 추가
            dir[0] += r-x;
        }
        // 출발지가 더 오른쪽이면 그만큼 가야하는 l추가 
        if(y-c>0){
            dir[1] += y-c;
        } else { //왼쪽이면 r 추가
            dir[2] += c-y;
        }
        StringBuilder sb = new StringBuilder();
         
        for(int i=0; i<k; i++){
            if(dir[0]>0 && x+1<=n ){
                sb.append("d");
                dir[0]--;
                x++;
                continue;
            }
            // a가 많을 때 du를 가는게아니라 dduu같은 d를 더 많이 갈 경우가 생기네
            if(x+1<=n && a>0){
                sb.append("d");
                a -=2;
                x++;
                dir[3]++; //내려간 만큼 올라가야하는 경우 더해주기
                continue;
            }
            if(dir[1]>0 && y-1>0) {
                sb.append("l");
                dir[1]--;
                y--;
                continue;
            }
            if(a>0 && y-1>0) {
                sb.append("l");
                a -=2;
                y--;
                dir[2]++; //왼쪽간 만큼 오른쪽 가는 경우 더해주기
                continue;
            }
            if(dir[2]>0 && y+1<=m){
                sb.append("r");
                dir[2]--;
                y++;
                continue;
            }
            if(a>0 && y+1<=m){
                sb.append("r");
                a -=2;
                y++;
                dir[1]++;
                continue;
            }
            if(dir[3]>0 && x-1>0){
                sb.append("u");
                dir[3]--;
                x--;
                continue;
            }
            if(a>0 && x-1>0){
                sb.append("u");
                a-=2;
                x--;
                dir[0]++;
                continue;
            }
        }
        return sb.toString();
    }
}