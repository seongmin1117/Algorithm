import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    마법사 상어와 토네이도
    
    빡구현 그 자체..
     */
    static int n,answer,r,c;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};
    static int[][] board;
    static int[] dir;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 방향 카운팅 배열
        dir = new int[2*n-1];
        for (int i=1; i<n; i++){
            dir[2*i-1] =i;
            dir[2*i-2] =i;
        }
        dir[2*n-2] = n-1;
        
        r = n/2;
        c = n/2;
        
        for (int i=0; i<dir.length; i++){
            int d = i%4;
            while (dir[i]-- >0){
                move(d);
            }
        }
        System.out.println(answer);
    }
    static void move(int dir){
        // 현재 방향의 90도 -90도
        int left = (dir+1)%4;
        int right = ((dir-1)+4) %4;

        int nr = r+ dr[dir];
        int nc = c+ dc[dir];
        int sand = board[nr][nc];
        int remain = sand -( (sand/100)*2 + (sand*2/100)*2 + (sand*5/100) + (sand*7/100)*2 +(sand*10/100)*2 );
        if (isValid(r+dr[left],c+dc[left])){
            board[r+dr[left]][c+dc[left]] += sand/100;
        } else {
            answer += sand/100;
        }
        if (isValid(r+dr[right],c+dc[right])){
            board[r+dr[right]][c+dc[right]] += sand/100;
        } else {
            answer += sand/100;
        }
        if (isValid(nr+dr[left],nc+dc[left])){
            board[nr+dr[left]][nc+dc[left]] += 7*sand/100;
        } else {
            answer += 7*sand/100;
        }
        if (isValid(nr+dr[right],nc+dc[right])){
            board[nr+dr[right]][nc+dc[right]] += 7*sand/100;
        } else {
            answer += 7*sand/100;
        }
        if (isValid(nr+dr[left]*2,nc+dc[left]*2)){
            board[nr+dr[left]*2][nc+dc[left]*2] += 2*sand/100;
        } else {
            answer += 2*sand/100;
        }
        if (isValid(nr+dr[right]*2,nc+dc[right]*2)){
            board[nr+dr[right]*2][nc+dc[right]*2] += 2*sand/100;
        } else {
            answer += 2*sand/100;
        }
        if (isValid(nr+dr[dir]+dr[left],nc+dc[dir]+dc[left])){
            board[nr+dr[dir]+dr[left]][nc+dc[dir]+dc[left]] += 10*sand/100;
        } else {
            answer += 10*sand/100;
        }
        if (isValid(nr+dr[dir]+dr[right],nc+dc[dir]+dc[right])){
            board[nr+dr[dir]+dr[right]][nc+dc[dir]+dc[right]] += 10*sand/100;
        } else {
            answer += 10*sand/100;
        }
        if (isValid(nr+dr[dir]*2,nc+dc[dir]*2)){
            board[nr+dr[dir]*2][nc+dc[dir]*2] += 5*sand/100;
        } else {
            answer += 5*sand/100;
        }
        if (isValid(nr+dr[dir],nc+dc[dir])){
            board[nr+dr[dir]][nc+dc[dir]] += remain;
        } else {
            answer += remain;
        }
        r = nr;
        c = nc;
    }
    static boolean isValid(int r, int c){
        return r>=0 && c>=0 && r<n && c<n;
    }
}
