import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());
        // f(n) = a1*n + a0 ,  g(n)= c*n ;
        // n0 <= 모든 n에 대하여 f(n)<= g(n) 이면 1  아니면 0
        // a1<c && a1*n0 +a0 <= c*  n0
        if(a1<=c && a1*n0 +a0 <= c*n0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
