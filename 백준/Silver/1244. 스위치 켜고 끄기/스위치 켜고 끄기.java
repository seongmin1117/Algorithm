import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    /*
    남학생은 받은 번호의 모든 배수 상태 바꾸기
    여학생은 그 번호 기준으로 양 옆 확인 후 같으면 계속 옆으로 가면서 다 바꾸기
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        List<int[]> students = new ArrayList<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            students.add(new int[] {x,num});
        }
        for (int[] student : students) {
            int num = student[1];
            //남학생
            if(student[0]==1){
                int idx =1;
                 while (num*idx<=n){
                     int a =num*idx;
                     if(a<=n){
                         if(arr[a]==1){
                             arr[a]=0;
                         } else if(arr[a]==0){
                             arr[a]=1;
                         }
                         idx++;
                     } else {
                         break;
                     }
                 }
            }
            //여학생
            else{
                int pre = num;
                int next = num;
                while(pre>=1 && next<=n){
                    if(arr[pre]==arr[next]){
                        if(arr[pre]==1){
                            arr[pre]=0;
                            arr[next]=0;
                        } else if(arr[pre]==0){
                            arr[pre]=1;
                            arr[next]=1;
                        }
                        pre--;
                        next++;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            sb.append(arr[i]).append(" ");
            if(i>=20 && i%20 ==0){
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
