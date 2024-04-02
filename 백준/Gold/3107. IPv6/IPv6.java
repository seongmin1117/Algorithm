import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    ipv6  32자리 4자리씩 끊기
    1. 각 그룹의 앞자리의 0의 전체 또는 일부를 생략 할 수 있다
    2. 만약 0으로만 이루어져 있는 그룹이 있을 경우 그 중 한 개 이상 연속된 그룹을 하나 골라 콜론 2개(::)로 바꿀 수 있다 (한 번만)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(":");
        boolean chk = false;
        StringBuilder sb= new StringBuilder();
        int count =0;
        for(int i=0; i<s.length; i++){
            int size = 4 - s[i].length();
            String zero = "0".repeat(size);
            //비어있고 아직 사용하지 않았으면
            if (s[i].equals("") && !chk){
                chk= true;
                int a = 8-s.length+1;
                while (a-->0) {
                    sb.append(zero).append(':');
                    count++;
                }
                continue;
            }
            if(i!=s.length-1){
                sb.append(zero).append(s[i]).append(':');
            } else {
                sb.append(zero).append(s[i]);
            }
            count++;
        }
        if(count!=8){
            int a = 8-count;
            sb.append(":");
            while (a-->0){
                if(a==0){
                    sb.append("0000");
                } else {
                    sb.append("0000").append(':');
                }
            }
        }
        System.out.println(sb);
    }
}
