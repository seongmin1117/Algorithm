import java.util.*;

public class Main {
    static int r,c,k,max_r,max_c;
    static int[][] board;
    static HashMap<Integer,Integer> map;
    static PriorityQueue<int[]> pq;

    static void sort_r(){
        for (int i=0; i<max_r; i++){
            map.clear();
            for (int i1 : board[i]) {
                if (i1 ==0) continue;
                map.put(i1,map.containsKey(i1) ? (map.get(i1)+1):1);
            }
            for (Map.Entry<Integer,Integer> entry : map.entrySet()){
                pq.add(new int[] {entry.getKey(), entry.getValue()});
            }
            int idx =0;
            int temp[] = new int[100];
            while (!pq.isEmpty()){
                int[] cur = pq.poll();
                temp[idx] = cur[0];
                temp[idx+1] = cur[1];
                idx +=2;
            }
            for (int l=0; l<100; l++){
                board[i][l] = temp[l];
            }
            max_c = Math.max(idx,max_c);
        }
    }

    static void sort_c(){
        for (int j=0; j<max_c; j++){
            map.clear();
            for (int i=0; i<max_r; i++){
                int i1 = board[i][j];
                if (i1 ==0) continue;
                map.put(i1,map.containsKey(i1) ? (map.get(i1)+1):1);
            }
            for (Map.Entry<Integer,Integer> entry : map.entrySet()){
                pq.add(new int[] {entry.getKey(), entry.getValue()});
            }
            int idx =0;
            int[] temp = new int[100];
            while (!pq.isEmpty()){
                int[] cur = pq.poll();
                temp[idx] = cur[0];
                temp[idx+1] = cur[1];
                idx +=2;
            }
            for (int l=0; l<100; l++){
                board[l][j] = temp[l];
            }
            max_r = Math.max(idx,max_r);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt()-1;
        c = sc.nextInt()-1;
        k = sc.nextInt();
        board = new int[100][100];
        map = new HashMap<>();
        pq = new PriorityQueue<>(((o1, o2) -> {
            int temp = o1[1]-o2[1];
            if (temp!=0){
                return temp;
            } else {
                return o1[0]-o2[0];
            }
        }));
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                board[i][j]= sc.nextInt();
            }
        }
        max_c =3;
        max_r =3;
        int count = 0;
        while (board[r][c]!=k){
            if (count>100) {
                System.out.println(-1);
                return;
            }
            count++;
            if (max_r >= max_c) {
                sort_r();
            } else {
                sort_c();
            }
        }
        System.out.println(count);
    }
}
