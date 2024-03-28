import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String,String> hashMap = new HashMap<>();
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String check = st.nextToken();
            if (check.equals("enter")) {
                hashMap.put(name,name);
            }else {
                hashMap.remove(name);
            }
        }
        List<String> list = new ArrayList<>(hashMap.values());
        Collections.sort(list,Collections.reverseOrder());

        for (String str : list){
            System.out.println(str);
        }
    }
}
