import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    /*
    탑
    1. 문제파악
        높이가 서로 다른 탑 N개가  왼쪽부터 오른쪽 방향으로 있고,
        모든 탑은 자신의 왼쪽 방향으로 레이저를 쏠 때, 자신보다 높이가 큰 탑을 처음 만나면 사라진다.
        각각의 탑에서 발사한 레이저 신호가 어느 탑에서 수신하는지 알아내라.
        N은 1부터 최대50만 , 높이는 1부터  최대 1억

    2. 접근방법
        N이50만이므로 O(N)으로 입력받으면서 한 번에 끝내야한다.
        1) 스택이 비어있을 경우 push 후 답에 0 추가
        2) 스택이 비어있지않고, peek의 값이 현재 값보다 클 경우 답에 peek의 인덱스 추가 후 push
        3) 스택이 비어있지않고, peek의 값이 현재 값보다 작을 경우 스택이 비거나 큰 값이 나올 떄까지 pop
         3-1) 스택이 비었을경우 push 후 답에 0추가
         3-2) 스택이 비어있지않을경우, 답에 peek의 인덱스 추가후 push
        
    3. 주의
        출력하는 인덱스는 1부터 시작한다.
        높이가 서로 다 다르다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>(); // 인덱스 , 값 순서로 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            int value = Integer.parseInt(st.nextToken());
                if(stack.isEmpty()){
                    stack.push(new int[] {i,value});
                    sb.append(0).append(" ");
                } else if(stack.peek()[1]>value){
                    sb.append(stack.peek()[0]).append(" ");
                    stack.push(new int[] {i,value});
                } else if (stack.peek()[1]< value){
                    while (!stack.isEmpty() && stack.peek()[1]<value){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        stack.push(new int[] {i,value});
                        sb.append(0).append(" ");
                    } else {
                        sb.append(stack.peek()[0]).append(" ");
                        stack.push(new int[] {i,value});
                    }
                }
        }

        System.out.println(sb);
    }
}
