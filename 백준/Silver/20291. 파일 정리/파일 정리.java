import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String[] split = st.nextToken().split("\\.");
            String s = split[1];

            if(map.get(s)==null){
                map.put(s,1);
            } else {
                map.replace(s, map.get(s)+1);
            }

        }
        List<String> answer = new ArrayList<>(map.keySet());
        Collections.sort(answer);
        for(String s : answer){
            int count = map.get(s);
            bw.write(s+" "+count);
            bw.newLine();
        }
        bw.close();
    }
}
