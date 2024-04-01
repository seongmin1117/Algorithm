import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[10001];
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            nums[num]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<10001; i++){
            if(nums[i]==0) continue;
            for(int j=0; j<nums[i]; j++){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
