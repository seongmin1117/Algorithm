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
        두 수의 합을 우선 구한 뒤 HashSet에 저장. (중복 제거 , 검색 O(1)) , 합이 입력 최대보다 클 경우 저장x
        twoSum = union[x]+union[y] ->  세수의 합 -union[l] = twoSum 이용
        집합의 두 숫자의 차이를 HashSet에서 검색, 있으면 출력하고 종료
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] union = new int[n];
        HashSet<Integer> twoSum = new HashSet<>();
        for (int i=0; i<n; i++){
            union[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(union);
        for (int i=n-1; i>=0; i--) {
            for (int j= n-1; j>=0; j--) {
                if(union[i]+union[j]>union[n-1]) continue;
                twoSum.add(union[i]+union[j]);
            }
        }
        for (int i=n-1; i>=0; i--) {
            for(int j : union){
                if(union[i]-j<union[0]) continue;
                if (twoSum.contains(union[i]-j)){
                    System.out.println(union[i]);
                    return;
                }
            }
        }
    }

}
