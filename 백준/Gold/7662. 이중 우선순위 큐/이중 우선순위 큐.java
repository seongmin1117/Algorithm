import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    이중 우선순위 큐
    1.문제
        삽입 , 우선순위 높은 것 삭제, 낮은 것 삭제 세가지 경우가 존재
        모든 입력이 끝나고 최댓값과 최솟값 출력

    2.조건
        T 테스트케이스, K 연산의 개수 최대 백만
        I n : 정수 n 을 큐에 삽입
        D 1 : 최댓값 삭제
        D -1: 최솟값 삭제  숫자가 같아도 하나만 삭제됨
        Q가 비어 있을경우 무시, 정수는 -21억 ~ +21억
    3.접근
        TreeMap 사용해서 최댓갑은 lastKey, 최솟값은 firstKey 찾기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- >0){
            TreeMap<Integer,Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st;

            while (k-- >0){
                st = new StringTokenizer(br.readLine());
                String id = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(id.equals("I")){
                    map.put(num, map.getOrDefault(num,0)+1);
                } else{
                    if(map.isEmpty()) continue;

                    if(num==1){
                        int max = map.lastKey();
                        if(map.get(max)==1){
                            map.remove(max);
                        } else {
                            map.replace(max,map.get(max)-1);
                        }
                    } else{
                        int min = map.firstKey();
                        if(map.get(min)==1){
                            map.remove(min);
                        } else {
                            map.replace(min,map.get(min)-1);
                        }
                    }
                }
            }
            if(map.isEmpty()){
                sb.append("EMPTY").append("\n");
            }else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
