import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Map<String,Integer> map = new HashMap<>();
        int num = 0;
         map.put(words[0],1);
        for(int i=1; i<words.length; i++){
            char[] pre = words[i-1].toCharArray();
            char[] cur = words[i].toCharArray();
            if(pre[pre.length-1]==cur[0]){
                if(map.containsKey(words[i])){
                    answer[0] = i%n+1;
                    answer[1] = i/n+1;
                    return answer;
                } else{
                    map.put(words[i],1);
                }
            } else{
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                return answer;
            }
        }
        return answer;
    }
}