import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Map<String,Integer> map = new TreeMap<>();

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
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            bw.write(entry.getKey()+" "+entry.getValue());
            bw.newLine();
        }
        bw.close();
    }
}
