import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    /*
    A 와 B 2

     */
    static String s;
    static int n;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        String t = br.readLine();
        n = s.length();
        dfs(t.length(),t);
        System.out.println(answer);
    }
    static void dfs(int k,String original){
        if (k==n){
            if (original.equals(s)){
                answer = 1;
            }
            return;
        }
        if (original.charAt(k-1)=='A') {
            dfs(k-1,original.substring(0,k-1));
        }
        if (original.charAt(0)=='B'){
            StringBuilder reverse = new StringBuilder(original.substring(1)).reverse();
            dfs(k-1,reverse.toString());
        }

    }
}
