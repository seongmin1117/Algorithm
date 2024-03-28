import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        String reverse = sb.reverse().toString();
        int num1 = Integer.parseInt(reverse.substring(0,3));
        int num2 = Integer.parseInt(reverse.substring(4,7));
        System.out.println(Math.max(num1, num2));
    }
}
