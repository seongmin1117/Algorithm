import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        //가장 큰 짝수의 제곱과 , 홀수의 제곱 찾기
        int x = Math.max(Math.abs(r1),Math.abs(c1)); // (2x+1)^2 +1
        int y = Math.max(Math.abs(r2),Math.abs(c2)); // (2y+2)^2

        int max = Math.max(x, y);
        int n = 2*max +1;
        int[] dr = {0,-1,0,1};
        int[] dc = {1,0,-1,0};


        int r = max;
        int c = max;
        int d = 0;
        int[] count = new int[2*n-1]; // 11 22 33 44 55 66 7
        for(int i=1; i<n; i++){
            count[2*i-2] = i;
            count[2*i-1] = i;
        }
        count[2*n-2] = n;
        int num = 1;
        int idx = 0;

        // r1 r2 -> 0 r2-r1
        int[][] board = new int[r2-r1+1][c2-c1+1];
        int a1 = r1+max;
        int b1 = c1+max;
        int a2 = r2+max;
        int b2 = c2+max;
        while (num<=n*n){
            if(r>=a1 && c>=b1 && r<=a2 && c<=b2){
                board[r-a1][c-b1] = num;
            }
            num++;
            count[idx]--;
            r += dr[d];
            c += dc[d];
            if(count[idx]==0){
                idx++;
                d= (idx)%4;
            }
        }

        StringBuilder sb = new StringBuilder();
        int length = 0;
        for(int i=0; i<=r2-r1; i++){
            for(int j=0; j<=c2-c1; j++){
               length = Math.max(board[i][j],length);
            }
        }
        length = String.valueOf(length).length();
        for(int i=0; i<=r2-r1; i++){
            for(int j=0; j<=c2-c1; j++){
                int size = String.valueOf(board[i][j]).length();
                String space = " ".repeat(length-size);
                sb.append(space).append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }
}
