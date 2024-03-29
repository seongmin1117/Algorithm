import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            hashSet.add(br.readLine());
        }
        int count = 0;
        for(int i=0; i<m; i++){
            String s = br.readLine();
            if (!hashSet.add(s)){
                treeSet.add(s);
                count++;
            }
        }
        sb.append(count).append("\n");
        for(String s : treeSet){
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
