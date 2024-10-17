import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown+yellow;
        for(int i=3; i<=brown; i++){
            for(int j=1; j<=i; j++){
                if(i*j==sum){
                    if((i+j-2)==brown/2){
                        answer[0] = i;
                        answer[1] = j;
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}