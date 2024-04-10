import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    마법사 상어와 파이어

     */
    static int n,m,k;
    static int[][] board;
    static int[] dr = {-1,-1,0,1,1,1,0,-1};
    static int[] dc = {0,1,1,1,0,-1,-1,-1};
    static Queue<Fire> fire = new ArrayDeque<>();
    static HashMap<Pair, List<Fire>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fire.add(new Fire(r,c,m,s,d));
        }
        while (k-- >0){
            one();
            two();
        }
        int answer = 0;
        while (!fire.isEmpty()){
            Fire cur = fire.poll();
            answer += cur.m;
        }
        System.out.println(answer);

    }
    static void one() {
        board = new int[n][n];
        map = new HashMap<>();
        while (!fire.isEmpty()){
            Fire cur = fire.poll();
            cur.move();
            map.putIfAbsent(new Pair(cur.r,cur.c),new ArrayList<>());
            map.get(new Pair(cur.r,cur.c)).add(cur);
            board[cur.r][cur.c]++;
        }
    }
    static void two(){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (board[i][j]==0) continue;
                if (board[i][j]==1){
                    List<Fire> fires = map.get(new Pair(i, j));
                    fire.addAll(fires);
                    continue;
                }
                List<Fire> fires = map.get(new Pair(i,j));
                int m = 0;
                int s = 0;
                int d = 0;
                for (Fire fire : fires) {
                    m += fire.m;
                    s += fire.s;
                    if (fire.d%2==0){
                        d++;
                    }
                }
                m/=5;
                if (m==0) continue;
                s/=fires.size();
                if (d==0 || d==fires.size()){
                    for (int k=0; k<=6; k+=2){
                        fire.add(new Fire(i,j,m,s,k));
                    }
                } else{
                    for (int k=1; k<=7; k+=2){
                        fire.add(new Fire(i,j,m,s,k));
                    }
                }
            }
        }
    }
    static class Pair{
        int r;
        int c;
        private Pair(int r,int c){
            this.r = r;
            this.c = c;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return r == pair.r && c == pair.c;
        }
        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
    static class Fire{
        int r; //행
        int c; //열
        int m; //질량
        int s; //속력
        int d; //방향

        private Fire(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
        private void move(){
            r += (dr[d]*s)%n +n;
            c += (dc[d]*s)%n +n;
            r %= n;
            c %= n;
        }
    }
}
