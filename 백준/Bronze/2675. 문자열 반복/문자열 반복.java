import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            char[] ch = st.nextToken().toCharArray();
            for(int j=0; j<ch.length; j++){
                for(int k=0; k<r; k++){
                    bw.write(ch[j]);
                }
            }
            bw.newLine();
        }
        bw.flush();
    }
}
