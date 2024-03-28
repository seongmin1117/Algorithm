import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String,Integer> map = new HashMap<>();
        int n  = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if(st.nextToken().equals("leave")){
                map.remove(name);
            } else {
                map.put(name,1);
            }
        }
        List<String> answer = new ArrayList<>(map.keySet());
        answer.sort(Collections.reverseOrder());
        for (String s : answer) {
            System.out.println(s);
        }

    }
}
