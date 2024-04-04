import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    세 수의 합
    1.문제
        세 수를 골랐을 때 그 합이 집합에 포함되는 가장 큰 합 구하기
    2.조건
        5<=N<=1000 , 모든 자연수는 2억보다 작거나 같다. 답은 항상 존재
        모든 수는 다르다. 하지만 같은 수를 더해도 된다.
        최악의 경우 1억개 부분합이 생김
    3.접근
        입력받으면서 배열에 저장 후 우선순위 큐에 추가
        입력값을 중복해서 더할 수 있고, 부분합의 중복값이 생기는 걸 막기위해 TreeSet 사용 (정렬까지)
        --시간초과와 메모리초과의 콜라보 발생--

        최대 1억개의 부분합이 생기므로.. 시간을 더 줄여야 함.
        O(N^2logN)까지 가능하다.
        두 수의 합을 우선 구한 뒤 배열에 저장 O(N^2),  twoSum[i] + a[i] 로 세 수의 합을 구한다.
        세수의 합을 바로 HashSet에서 검색 O(1) 있으면 출력하고 종료
        TreeSet이 메모리를 많이 차지해서 ? 메모리 초과 ?
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> one = new TreeSet<>(((o1, o2) -> o2-o1));
        TreeSet<Integer> twoSum = new TreeSet<>(((o1, o2) -> o2-o1));
        TreeSet<Integer> asc = new TreeSet<>();
        for (int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            one.add(num);
            asc.add(num);
        }
        for (Integer i : one) {
            for (Integer j : one) {
                twoSum.add(i+j);
            }
        }

        for (Integer i : one) {
            for(Integer j : asc){
                if (twoSum.contains(i-j)){
                    System.out.println(i);
                    return;
                }
            }
        }
    }

}
