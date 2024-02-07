import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.next().split("");
        int pre = -1;
        int zero = 0;
        int one =0;
        int total =0;
        for (int i=0; i<s.length; i++){
            if (s[i].equals("0") && pre!=0){
                pre=0;
                zero++;
                total++;
            } else if (s[i].equals("1") && pre!=1){
                pre=1;
                one++;
                total++;
            }
        }
        if (total==1){
            System.out.println(0);
        }else {
            System.out.println(Math.min(zero,one));
        }


    }
}
