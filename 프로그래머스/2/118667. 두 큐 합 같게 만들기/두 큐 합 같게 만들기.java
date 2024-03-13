import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            sum1 += queue1[i];
        }
        for(int i=0; i<queue2.length; i++){
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        long avg = (sum1+sum2)/2;
        int count = 0;
        while(true){
            if(count>500000){
                return -1;
            }
            if(sum1>sum2){
                int cur = q1.poll();
                sum1 -= cur;
                sum2 += cur;
                q2.add(cur);
            } else if(sum1<sum2){
                int cur = q2.poll();
                sum1 += cur;
                sum2 -= cur;
                q1.add(cur);
            } else{
                break;
            }
            count++;
        }
        return count;
    }
}