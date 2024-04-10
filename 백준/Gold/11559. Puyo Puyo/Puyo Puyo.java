import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    puyo puyo
     */

    static char[][] board = new char[12][6];
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,-1,0,1};
    static Queue<Pair> q = new ArrayDeque<>();
    static Queue<Character> temp = new ArrayDeque<>();
    static List<Pair> clearMap =new ArrayList<>();
    static List<Pair> puyo =new ArrayList<>();
    static boolean clear;

    static void down(){
        for (Pair pair: clearMap){
            board[pair.r][pair.c]='.';
        }
        for (int j=0; j<6; j++){
            for (int i=11; i>=0; i--){
                if (board[i][j]!='.' && !puyo.contains(new Pair(i,j))){
                    temp.add(board[i][j]);
                    board[i][j] = '.';
                }
            }
            int idx = 11;
            while (!temp.isEmpty()){
                board[idx][j]= temp.poll();
                idx--;
            }
        }
    }
    static void game(){
        boolean[][] visited = new boolean[12][6];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                q.clear();
                puyo.clear();
                q.add(new Pair(i,j));
                while (!q.isEmpty()) {
                    Pair cur = q.poll();
                    int r = cur.r;
                    int c = cur.c;
                    for (int d = 0; d< 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (!isValid(nr,nc) || board[nr][nc] =='.') continue;
                        if (visited[nr][nc] || board[r][c] != board[nr][nc]) continue;
                        visited[nr][nc] = true;
                        q.add(new Pair(nr,nc));
                        puyo.add(new Pair(nr,nc));
                    }
                }
                if (puyo.size() >= 4) {
                    clear = true;
                    clearMap.addAll(puyo);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Pair> pu = new ArrayList<>();
        for (int i=0; i<12; i++){
            board[i]= br.readLine().toCharArray();
            for (int j=0; j<6; j++){
                if (board[i][j] != '.') {
                    pu.add(new Pair(i,j));
                }
            }
        }
        int result =0; //연쇄 횟수
        while (true){
            clear = false;
            game();
            if (clear){
                result++;
                down();
            } else {
                System.out.println(result);
                return;
            }
            clearMap.clear();
        }
    }
    static boolean isValid(int r, int c){
        return r>=0 && c>=0 && r < 12 && c < 6;
    }
    static class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}

