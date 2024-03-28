import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        double max = 0;
        double sum = 0;
        for(int i=0; i<n; i++){
            double num = Double.parseDouble(st.nextToken());
            sum += num;
            max = Math.max(max,num);
        }
        System.out.println(sum/max/n*100);
    }
}
