import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] used = new int[26]; //알파벳 사용한 수
        String s = br.readLine().toUpperCase(); //대문자로
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            used[ch-'A']++;
        }
        
        int max = 0;
        int max_idx = 0;
        int count = 1;
        
        for(int i=0; i<26; i++){
            if(used[i]>max) {
                count=1; //최댓값 갱신하면 카운트 초기화
                max = used[i];
                max_idx = i;
            } else if(used[i]==max){
                count++;
            }
        }
        // 최대가 1개가 아니면 ? 출력
        if(count==1){
            System.out.println((char) (max_idx+'A'));
        } else {
            System.out.println('?');
        }
    }
}
