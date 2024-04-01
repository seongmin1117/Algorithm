import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] board = new int[101][101];
        for(int i=1; i<=3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=3; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int n = -1;
        int maxR = 3;
        int maxC = 3;
        while (n++<100){
            if(board[x][y]==k){
                System.out.println(n);
                return;
            }

            if(maxR>=maxC){
                for(int r=1; r<=maxR; r++){
                    TreeMap<Integer,Integer> map = new TreeMap<>(); // 키: 숫자 , 값: 개수
                    PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> { // 숫자, 개수  ( 개수 우선으로)
                        int temp = o1[1]-o2[1];
                        if (temp!=0){
                            return temp;
                        } else {
                            return o1[0]-o2[0];
                        }
                    }));
                    for( int c=1; c<=maxC; c++){
                        int num = board[r][c];
                        if(num==0) continue;
                        map.put(num,map.getOrDefault(num,0)+1);
                    }
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        pq.add(new int[] {entry.getKey(), entry.getValue()});
                    }
                    int idx = 1;
                    int[] temp = new int[101];
                    while (!pq.isEmpty()){
                        int[] cur = pq.poll();
                        temp[idx] = cur[0];
                        temp[idx+1] = cur[1];
                        idx+=2;
                    }
                    for(int l=1; l<=100; l++){
                        board[r][l] = temp[l];
                    }
                    maxC = Math.max(maxC,idx);
                }
            } else if(maxC>maxR){
                for(int c=1; c<=maxC; c++){
                    TreeMap<Integer,Integer> map = new TreeMap<>(); // 키: 숫자 , 값: 개수
                    PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> { // 숫자, 개수  ( 개수 우선으로)
                        int temp = o1[1]-o2[1];
                        if (temp!=0){
                            return temp;
                        } else {
                            return o1[0]-o2[0];
                        }
                    }));
                    for(int r=1; r<=maxR; r++){
                        int num = board[r][c];
                        if(num==0) continue;
                        map.put(num,map.getOrDefault(num,0)+1);
                    }
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        pq.add(new int[] {entry.getKey(), entry.getValue()});
                    }
                    int idx = 1;
                    int[] temp = new int[101];
                    while (!pq.isEmpty()){
                        int[] cur = pq.poll();
                        temp[idx] = cur[0];
                        temp[idx+1] = cur[1];
                        idx+=2;
                    }
                    for(int l=1; l<=100; l++){
                        board[l][c] = temp[l];
                    }
                    maxR = Math.max(maxR,idx);
                }
            }
        }
        System.out.println(-1);
    }
}
