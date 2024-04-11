import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
       상어 중학교
       검은색:-1 , 무지개:0 , 일반: 1~M , 상하좌우가 인접한 칸
       블록그룹: 일반블록이 적어도 하나 존재하면서 색이 같아야하고 검은색 없고 무지개 여러가능
        그룹에 속한 블록의 개수는 2이상, 모든 블록이 이어져 있어야 함.
        기준은 일반블록 중 행이 가장 작은 블록, 여러개라면 열이 가장 작은 블록 (0,0 부터 탐색하면 됨)

        1. 크기가 가장 큰 블록그룹 찾기
            1-0 블록의 크기가 가장 큰 순 ,같다면
            1-1 무지개 블록이 가장 많은 순 ,같다면
            1-2 기준 블록의 행이 가장 큰 순 ,같다면
            1-3 기준 블록의 열이 가장 큰 순

        2. 1에서 찾은 블록그룹의 모든 블록제거 ( 영향안주는 -2로 만들기)
        2-1 블록 수의 제곱만큼 점수 획득 (size*size)
        3. 중력이 작용한다. (검은색 블록을 제외한 모든 블록을 밑으로 내리기, 다른 블록이나 경계에 닿을 때 까지)
        4. 90도 반시계 방향 회전
        5. 중력이 작용한다.
     */
    static int n,m,answer;
    static int[] dr = {1,0,-1,0};
    static int[] dc ={0,-1,0,1};
    static int[][] board;
    static Queue<Block> q = new ArrayDeque<>(); // BFS에서 사용할 큐

    static PriorityQueue<Group> pq = new PriorityQueue<>(((o1, o2) -> {
        // 크기 -> 무지개 -> 행 -> 열 (다 내림차순)
        int size = o2.blocks.size() - o1.blocks.size();
        if (size==0){
            int rainbow = o2.rainbow - o1.rainbow;
            if (rainbow==0){
                int row = o2.r - o1.r;
                if (row ==0){
                    return o2.c - o1.c;
                }
                return row;
            }
            return rainbow;
        }
        return size;
    }));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 블록 그룹이 존재하는 동안
        while (true){
            bfs(); //1번 : 블록그룹 찾기
            if (pq.isEmpty()) break; // 블록그룹이 없으면 종료
            removeGroupAndGetPoint(); //2번 : 지우고 점수 획득
            down(); //3번 : 중력
            cur(); //4번 : 반시계 90도 회전
            down(); //5번 : 중력
        }
        System.out.println(answer);

    }
    static void bfs(){ // 1번 과정
        pq.clear(); // 기존 블록그룹 초기화
        boolean[][] visited = new boolean[n][n]; // 일반블록 방문확인
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (board[i][j]<=0|| visited[i][j]) continue; // 방문안한 일반 블록만 시작가능
                boolean[][] visitedRB = new boolean[n][n]; // 무지개블록 방문처리는 일반 블록마다 새로 시작 가능
                visited[i][j] = true; //일반 블록 방문처리
                q.add(new Block(i,j,board[i][j])); // 탐색할 Q에 기준 블록 넣기
                Group group = new Group(i,j,0); // 현재 기준 블록으로 그룹 생성 (좌표,무지개 수)
                group.addBlock(new Block(i,j,board[i][j])); // 그룹에 기존 블록추가

                while (!q.isEmpty()){
                    Block cur = q.poll();
                    for (int d=0; d<4; d++){
                        int r = cur.r + dr[d];
                        int c = cur.c + dc[d];
                        // 범위 밖, 색이 다를 때 , 방문한 무지개일 때, 방문한 블록 일때 넘어가기
                        if (!isValid(r,c,cur.color) || visitedRB[r][c] || visited[r][c] ) continue;

                        if (board[r][c]==0){ //무지개 블록일 때
                            group.updateRainbow(); //무지개 수 증가시키기
                            group.addBlock(new Block(r,c,0));
                            visitedRB[r][c] = true; // 무지개 방문 처리
                            q.add(new Block(r,c,cur.color)); // 탐색할 큐에 기존 색을 넣어야한다.
                            continue;
                        }
                        // 같은색 블록일 때 , 위와 동일
                        group.addBlock(new Block(r,c,cur.color));
                        visited[r][c] = true; // 일반 블록 방문 처리
                        q.add(new Block(r,c,cur.color));
                    }
                }
                if (group.blocks.size()>=2){ //블록 그룹의 크기가 2이상일 때만 추가
                    pq.add(group);
                }
            }
        }
    }
    static void removeGroupAndGetPoint(){ // 2번과정
        if (!pq.isEmpty()){
            Group group = pq.poll(); // 우선순위가 가장 높은 그룹
            group.removeBlocks(); // 블록을 지우고
            group.getPoint(); // 그만큼 포인트 증가
        }
    }
    static void down(){ //3번 5번
        for (int j=0; j<n; j++){
            Queue<Block> temp = new ArrayDeque<>();
            for (int i=n-1; i>=0; i--){
                 if (board[i][j]==-2) continue; // 지워진 블록은 넘기기
                 temp.add(new Block(i,j,board[i][j]));
                 board[i][j] = -2; // 움직이는 블록 지워놓기
            }

            int idx = n-1;
            while (!temp.isEmpty()){
                Block cur = temp.poll();
                if (cur.color==-1){ // 블랙은 고정!!
                    board[cur.r][j] = -1;
                    idx = cur.r-1;
                    continue;
                }
                board[idx][j] = cur.color; // 블랙 아니면 쭉 내리기
                idx--;
            }
        }
    }
    static void cur(){ // 4번 : 반시계 90도 회전, 행과 열의 크기가 같음
        int[][] temp = new int[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                temp[i][j] = board[j][n-1-i]; // 기존 열은 행이되고  , 기존 행의 아래부터 새로운 열의 시작이 된다
            }
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                board[i][j] = temp[i][j];
            }
        }
    }

    static boolean isValid(int r, int c, int color){
        return r>=0 && c>=0 && r<n && c<n && (board[r][c]==color || board[r][c]==0)  ;
    }
    static class Block{
        int r;
        int c;
        int color;
        private Block(int r, int c, int color){
            this.r = r;
            this.c = c;
            this.color = color;
        }
    }
    static class Group{
        int r;
        int c;
        int rainbow;
        List<Block> blocks = new ArrayList<>();
        private Group(int r, int c, int rainbow){
            this.r = r;
            this.c = c;
            this.rainbow = rainbow;
        }
        private void updateRainbow(){
            rainbow++;

        }
        private void addBlock(Block block){
            blocks.add(block);
        }
        private void removeBlocks(){
            for (Block block : blocks) {
                board[block.r][block.c] = -2; // -2이면 지워진 것
            }
        }
        private void getPoint(){
            int size = blocks.size();
            answer += size*size;
        }
    }
}
