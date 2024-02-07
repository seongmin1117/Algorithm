import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.next().split("-");
        int ans =0;
        for (int i=0; i<s.length; i++){
            String[] s2 = s[i].split("\\+");
            int res = 0;
            for (int j=0; j<s2.length; j++){
                res += Integer.parseInt(s2[j]);
            }
            if (i!=0) ans-=res;
            if (i==0) ans+=res;
        }
        System.out.println(ans);
    }
}
