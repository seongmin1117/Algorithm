import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    /*
    오목
    검은알 1 흰알 2, 빈공간 0
    가로 세로 대각선 5개일 때 승리  ( 6개이상 승리 X)
    검은색이 이기면 1, 흰색이 이기면 2, 무승부 0
    검은색 또는 흰색이 이겼을 경우 가장 왼쪽 or 가장 위 의 행,열 번호 출력

    dfs로 같은 방향에 같은 색이 있을 때 계속 가서 최대 5개이면 승리
     */
    static  int[][] board;
    static boolean[][][] visited;
    static List<int[]> black,white;
    static int[] dr = {1,0,-1,0,1,1,-1,-1};
    static int[] dc = {0,-1,0,1,-1,1,1,-1};
    static StringBuilder sb = new StringBuilder();
    static int[] answer = new int[2];
    static boolean chk = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[20][20];
        visited = new boolean[20][20][8];
        black = new ArrayList<>();
        white = new ArrayList<>();
        for(int i=1; i<=19; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=19; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] ==1){
                    black.add(new int[]{i,j});
                } else if(board[i][j] ==2){
                    white.add(new int[] {i,j});
                }
            }
        }
        //검은색 확인
        for(int i=0; i<black.size(); i++){
            int[] cur = black.get(i);
            int curR = cur[0];
            int curC = cur[1];
            for(int d=0; d<8; d++){
                dfs(1,curR,curC,d,1,curR-dr[d], curC-dc[d]);
                //5목이고 시작돌의 뒤 확인해서 벽이거나 같은색이 아닐경우 정답
                if((chk)){
                    if(curC<answer[1]){
                        sb.append(curR).append(" ").append(curC);
                    } else if(curC>answer[1]){
                        sb.append(answer[0]).append(" ").append(answer[1]);
                    } else {
                        if(curR<answer[0]){
                            sb.append(curR).append(" ").append(curC);
                        } else {
                            sb.append(answer[0]).append(" ").append(answer[1]);
                        }
                    }
                    System.out.println(sb);
                    return;
                }
            }
        }

        //흰색 확인
        for(int i=0; i<white.size(); i++){
            int[] cur = white.get(i);
            int curR = cur[0];
            int curC = cur[1];
            for(int d=0; d<8; d++){
                dfs(1,curR,curC,d,2, curR-dr[d], curC-dc[d]);
                if(chk){
                    if(curC<answer[1]){
                        sb.append(curR).append(" ").append(curC);
                    } else if(curC>answer[1]){
                        sb.append(answer[0]).append(" ").append(answer[1]);
                    } else {
                        if(curR<answer[0]){
                            sb.append(curR).append(" ").append(curC);
                        } else {
                            sb.append(answer[0]).append(" ").append(answer[1]);
                        }
                    }
                    System.out.println(sb);
                    return;
                }
            }
        }
        System.out.println(0);

    }
    //연속되는 개수와 현재 방향
    static void dfs(int k , int r, int c, int d, int color, int preR, int preC){
        int nr = r+ dr[d];
        int nc = c+ dc[d];
        if(k==5 ){
            //더 연속되는지 검증 후 없을 때 정답
            //1. 벽이아니고 같은색이 아닐경우 정답 (예외, 첫번째 돌의 이전 색이 같을경우 6목)
            if(nr>=1 && nr<=19 && nc>=1 && nc<=19 && board[nr][nc]!=color &&
                    (preR>=1 && preR<=19 && preC>=1 && preC<=19)&& board[preR][preC]!=color){
                chk =true;
                sb.append(color).append("\n");
                answer[0] = r;
                answer[1] = c;
                // (preR<1||preR>19||preC<1||preC>19)
            }//2. 벽일 경우 정답
            else if( (nr<1 || nr>19 || nc<1 || nc>19) &&
                    (preR>=1 && preR<=19 && preC>=1 && preC<=19)&& board[preR][preC]!=color){
                chk =true;
                sb.append(color).append("\n");
                answer[0] = r;
                answer[1] = c;
            } else if(nr>=1 && nr<=19 && nc>=1 && nc<=19 && board[nr][nc]!=color && (preR<1||preR>19||preC<1||preC>19)){
                chk =true;
                sb.append(color).append("\n");
                answer[0] = r;
                answer[1] = c;
            } else if((nr<1 || nr>19 || nc<1 || nc>19) && (preR<1||preR>19||preC<1||preC>19)){
                chk =true;
                sb.append(color).append("\n");
                answer[0] = r;
                answer[1] = c;
            }



            return;
        }
        //보드판 안에 있고 같은 색이면
        if(nr>=1 && nr<=19 && nc>=1 && nc<=19 && board[nr][nc]==color){
            dfs(k+1,nr,nc,d,color,preR,preC);
        }
    }
}
