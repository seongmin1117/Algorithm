import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    가스관
    1.문제
        M -> Z 로 가는데 비어있는 한 칸에 어떤 블록이 들어가야 하는지 구하기
        항상 답이 존재하고 , 가스의 흐름이 유일한 경우만 주어진다. 지워진 블록의  (행, 열, 종류) 출력

    2.조건
        1 <= R,C <= 25  모스크바의 M , 자그레브 Z 한개씩 존재
        '|' '-' '+' 1,2,3,4 존재

         '+'는 특별한 블록으로, 아래 예시처럼 두 방향 (수직, 수평)으로 흘러야 한다.


    3.접근
        비어있는 칸마다 상하좌우의 블록이 뭔지 파악한 후 switch case 문으로 들어가야할 블록 넣기
        답이 한개이기 때문에 블록이 들어갈 수 있으면 무조건 정답이다

        예외, M Z를 바로 이어버려서 버려지는 블록이 생기면 안된다.. 음 ..
     */
    static int R,C;
    static int[] dr ={-1,1,0,0}; //상하좌우
    static int[] dc ={0,0,-1,1};
    static StringBuilder answer = new StringBuilder();
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for (int i=0; i<R; i++){
            board[i] = br.readLine().toCharArray();
        }
        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                if (board[i][j]!='.') continue;
                char block = bfs(i,j);
                if(block!='0'){
                    answer.append(i+1).append(" ").append(j+1).append(" ").append(block);
                    System.out.println(answer);
                    return;
                }
            }
        }
    }
    static char bfs(int r, int c){
        StringBuilder sb = new StringBuilder();
        for (int d=0; d<4; d++){
            int nr = r+ dr[d];
            int nc = c+ dc[d];
            if (!isValid(nr,nc)) {
                sb.append(0);
                continue;
            }
            sb.append(check(d,board[nr][nc]));
        }
        return setBlock(sb);
    }
    static int check(int d, char block){
        if ( block=='M' || block=='Z'){
            return 0;
        }
        switch (d){
            case 0:
                if (block=='|' || block=='+' || block=='1' || block=='4') return 1;
                break;
            case 1:
                if (block=='|' || block=='+' || block=='2' || block=='3') return 1;
                break;
            case 2:
                if (block=='-' || block=='+' || block=='1' || block=='2') return 1;
                break;
            case 3:
                if (block=='-' || block=='+' || block=='3' || block=='4') return 1;
                break;
        }
        return 0;
    }
    static char setBlock(StringBuilder sb) {
        String s = sb.toString();
        switch (s) {
            case "1100":
                return '|';
            case "0011":
                return '-';
            case "1111":
                return '+';
            case "0101":
                return '1';
            case "1001":
                return '2';
            case "1010":
                return '3';
            case "0110":
                return '4';
            default:
                return '0';
        }
    }
    static boolean isValid(int r, int c){
        return r>=0 && c>=0 && r<R && c<C;
    }
}
