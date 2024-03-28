import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s =  sc.next();
        int n = s.length();
        Set<String> set = new HashSet<>();
        for(int i=1; i<=n; i++){
            for(int j=0; j<n; j++){
                if(j+i>n) continue;
                set.add(s.substring(j,j+i));
            }
        }
        System.out.println(set.size());
    }
}
