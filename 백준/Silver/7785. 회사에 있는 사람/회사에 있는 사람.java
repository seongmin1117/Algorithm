import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> set = new HashSet<>();
        int n = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if (st.nextToken().equals("leave")) {
                set.remove(name);
            } else {
                set.add(name);
            }
        }
        
        List<String> answer = new ArrayList<>(set);
        Collections.sort(answer);
        for (int i = answer.size() - 1; i >= 0; i--) {
            bw.write(answer.get(i));
            bw.newLine();
        }
        bw.close();
    }
}
