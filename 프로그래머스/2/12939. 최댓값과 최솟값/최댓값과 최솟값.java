import java.util.*;
class Solution {
    public String solution(String s) {
        String[] arr_s = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
    
        for(String str : arr_s){
            int x = Integer.parseInt(str);
            max = Math.max(max,x);
            min = Math.min(min,x);
        }
        String ans = min+" "+max;
        return ans;
    }
}