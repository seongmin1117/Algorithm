
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1; i<=2*n-1; i++) {
            int star = i;
            if(star>n) star=2*n-i;
            for(int j=0; j<star; j++){
                bw.write("*");
            }
            for(int j=0; j<2*(n-star); j++){
                bw.write(" ");
            }
            for(int j=0; j<star; j++){
                bw.write("*");
            }
            bw.newLine();
        }
        bw.flush();
    }
}
