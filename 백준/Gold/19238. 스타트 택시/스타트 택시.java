import java.io.*;
import java.util.*;

public class Main {
    static int n,m,fuel,start_r,start_c,count,answer;
    static int[][] board;
    static int[][] arrived;
    static int[] dr = {-1,0,0,1};
    static int[] dc = {0,-1,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        //택시 시작 위치
        start_r = Integer.parseInt(st.nextToken())-1;
        start_c = Integer.parseInt(st.nextToken())-1;
        //손님의 위치 ( 출발: 2부터 , 도착 : -2부터 )
        arrived = new int[m][2];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken())-1;
            int start_y = Integer.parseInt(st.nextToken())-1;
            int end_x = Integer.parseInt(st.nextToken())-1;
            int end_y = Integer.parseInt(st.nextToken())-1;
            board[start_x][start_y] = 2+i;
            arrived[i][0] = end_x;
            arrived[i][1] = end_y;
        }
        for(int i=0; i<m; i++){
            bfs(start_r,start_c);
            if(answer ==-1){
                System.out.println(answer);
                return;
            }
        }
        if(m==count){
            System.out.println(fuel);
        } else {
            System.out.println(-1);
        }
    }
    //가장 가까운 손님을 만나면 태우기 , 우선순위 큐 ?
    static void bfs(int x, int y){
            PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    int cmp = Integer.compare(o1[2],o2[2]); //거리 우선
                    if(cmp !=0) {
                        return cmp;
                    } else {
                        return Integer.compare(o1[0],o2[0]); //행
                    }
                }
            });
            List<int[]> list = new ArrayList<>();
            boolean[][] visited = new boolean[n][n];
            q.add(new int[] {x,y,0}); //택시 출발 위치와 이동한 거리 추가
            visited[x][y]= true;
            int dis = Integer.MAX_VALUE;
            while (!q.isEmpty()){
                int[] cur = q.poll(); //현재 택시 위치
                int cur_r = cur[0];
                int cur_c = cur[1];
                int distance = cur[2];
                if(distance>fuel){ // 연료보다 이동거리가 크면 종료
                    answer = -1;
                    return;
                }
                if(!list.isEmpty() && dis == distance &&board[cur_r][cur_c]>1){
                    list.add(new int[] {cur_r,cur_c});
                    continue;
                }
                if(distance>dis) break;
                // 가장 가까운 손님이면 태우는게 아니라  같은 거리인 큐 다 빼서 확인 ?
                if(board[cur_r][cur_c]>1){
                    list.add(new int[] {cur_r,cur_c});
                    dis = distance;
                    continue;
                }
                for(int d=0; d<4; d++){
                    int nr = cur_r +dr[d];
                    int nc = cur_c +dc[d];
                    if(nr<0 ||nc<0 || nr>=n || nc>=n || board[nr][nc]==1 || visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    q.add(new int[]{nr,nc,distance+1});
                }
            }
            int min_r = Integer.MAX_VALUE;;
            int min_c = Integer.MAX_VALUE;
            for(int[] cur : list){
                if(cur[0]<min_r){
                    min_r = cur[0];
                    min_c = cur[1];
                } else if( cur[0]==min_r){
                    if(cur[1]<min_c){
                        min_c = cur[1];
                    }
                }
            }
            if(list.isEmpty()) return;
        int guest = board[min_r][min_c];
        board[min_r][min_c] = 0;
        fuel -= dis;
        go(min_r,min_c,guest-2); // guest-2 가 손님번호다.
    }
    //그 손님의 목적지까지 가는 최단거리 계산 후 , 연료 체크
    static void go(int x, int y, int guest){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.add(new int[] {x,y,0}); // 손님을 태운 택시의 출발지와 도착지까지 거리
        visited[x][y] = true;
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            int distance = cur[2];
            if(distance > fuel) {
                answer = -1;
                return;
            }
            for(int d=0; d<4; d++){
                int nr = curR + dr[d];
                int nc = curC + dc[d];
                if(nr<0 || nc<0 || nr>=n ||nc>=n || board[nr][nc]==1 || visited[nr][nc]) continue;
                if(nr == arrived[guest][0] && nc == arrived[guest][1]) {
                    if(distance+1>fuel){
                        answer = -1;
                        return;
                    }
                    fuel += distance+1;
                    start_r = nr;
                    start_c = nc;
                    count++;
                    return;
                }
                visited[nr][nc] = true;
                q.add(new int[]{nr,nc,distance+1});
            }
        }
    }
}
