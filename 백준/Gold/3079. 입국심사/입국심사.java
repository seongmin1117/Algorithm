import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    1.문제
        한 심사대에는 한 번에 한 사람만, 더 빠른 심사대를 기다렸다가 가도 됨
        모든사람이 심사 받는데 걸리는 최소 시간 /최적화 문제를 결정문제로,매개변수 탐색
        -> 시간이 x일때 모든사람이 심사를 다 받을 수 있나 없나?
    2.조건
        심사대 최대 10만개
        사람 최대 10억명
        심사하는데 걸리는 시간 최대 10억 , 출력 long으로 해야될 듯
    3.접근
        우선순위 큐에 입력을 받는다. (심사시간)
        심사대에 한 명이 들어가면 큐에서 빼고, (기다려야하는 시간+원래시간 , 원래시간)을 다시 넣는다.
        마지막 사람이 기다려야하 는 시간 출력
        --메모리초과--
        10만 -> nlogn = 166만 이분탐색으로 풀어야 한다.

       시간이 x일 때 모든사람이 심사를 받을 수 있으면 최소 값 갱신.
       이분탐색이 모두 끝날 때 까지 갱신 후 출력

     */
    static int n,m;
    static long start,end,mid,answer,count;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        start = 1;
        end = (long) arr[0]*m;
        answer =(long) arr[0]*m; //가장 작은 값 * 사람 수가 최대가 됨

        while (start<=end){
            mid = (start+end)/2;
            func();
        }
        System.out.println(answer);
    }
    static void func(){
        count = 0;
        for(int i=0; i<n; i++){
            count +=  mid/arr[i];
            if(count>=m) break;
        }
        if(count<m){
            start = mid+1;
        }else if(count>=m){
            end = mid-1;
            answer = Math.min(answer,mid);
        }
    }
}