import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int size = arr.length;
        Arrays.sort(arr);
        int max = arr[size-1];
        int x = max;
        int y = 1;
        boolean chk = false;
        while(true){
            for(int i=0; i<size; i++){
                if(x%arr[i]!=0){
                    chk = false;
                    break;
                }
                chk = true;
            }
            
            if(chk){
                return x;
            }
             y++;
            x=max*y;
        }
    }
}