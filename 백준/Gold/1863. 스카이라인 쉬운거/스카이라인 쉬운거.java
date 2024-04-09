import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    /*
     스카이라인 쉬운거

     Stack 사용
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek()>=y) {
                if (stack.peek() > y) {
                    answer++;
                }
                stack.pop();
            }
            stack.add(y);
        }
        while (!stack.isEmpty()){
            int cur = stack.pop();
            if (cur==0)  continue;
            answer++;
        }
        System.out.println(answer);
    }
}
