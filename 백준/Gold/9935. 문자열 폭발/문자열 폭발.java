import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    /*
    문자열 폭발
    1.문제파악
        폭발문자열이 폭발하면 사라지고 남은 문자열이 합쳐진다.
        문자열이 폭발문자열을 포함하고 있는 경우 모든 폭발 문자열이 폭발한다.
        새로 생긴 문자열에 폭발 문자열이 포함될 수 있으므로 다 터질때까지 반복한다.
        남아있는 문자가 없는 경우 "FRULA" , 아니면 남아있는 문자 출력
    2.접근방법
        크기가 크기때문에 입력을 받으면서 정답까지 저장해야 best
        입력을 받을 때 문자열의 인덱스와 비교해서 같으면 stack에 인덱스를 저장하고 인덱스 ++
        현재 인덱스와 다른데, 시작 인덱스와 같다면 stack에 0을 저장하고 인덱스를 1로 갱신
        폭탄문자열이 아닐시 출력값에 저장.
    3.주의사항
        문자열의 길이는 1부터 백만 , 폭발문자열은 같은 문자열을 두 개 이상 포함하지 않는다.
        문자열이 중복되지 않기 때문에 인덱스를 활용. (폭탄의 각 문자는 고유의 인덱스가 있다.)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray(); // 입력
        char[] bomb = br.readLine().toCharArray(); //폭탄
        Stack<int[]> stack = new Stack<>(); //폭탄인덱스와 문자인덱스 를 저장할 스택
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int i=0; i<ch.length; i++){
            if(ch[i]==bomb[idx]){
                stack.push(new int[]{idx,i});
                idx++;
                if(idx==bomb.length){
                    for(int j=0; j< bomb.length; j++){
                        int removeI = stack.pop()[1];
                        ch[removeI] = ' ';
                    }
                    if(stack.isEmpty()){
                        idx =0;
                    } else {
                        idx = stack.peek()[0]+1;
                    }
                }
            } else if(ch[i]==bomb[0]){
                stack.push(new int[]{0,i});
                idx =1;
            } else { // 다른 문자가 껴있으면 초기화
                stack.clear();
                idx = 0;
            }
        }
        for(int i=0; i<ch.length; i++){
            if(ch[i]==' ') continue;
            sb.append(ch[i]);
        }
        if(sb.isEmpty()){
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }

    }
}
