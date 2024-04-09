import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        PriorityQueue<int[]> req = new PriorityQueue<>((o1,o2)->{ //요청시간순 같으면 소요시간
            int temp = o1[0]-o2[0];
            if(temp==0) return o1[1]-o2[1];
            return temp;
        });
        PriorityQueue<int[]> dur = new PriorityQueue<>((o1,o2)->{//소요시간순 같으면 요청시간
            int temp = o1[1]-o2[1];
            if(temp==0) return o1[0]-o2[0];
            return temp;
        });
        for(int[] job : jobs){
            req.add(job);
        }
        
        int[] cur =req.poll();
        int sum = cur[1];
        int start = cur[0]+cur[1];
        
        for(int i=1; i<n; i++){
            
            while( !req.isEmpty() && start>=req.peek()[0]){
                dur.add(req.poll());
            }
            
            if(!dur.isEmpty()){
            cur = dur.poll();
            int request = cur[0];
            int duration = cur[1];
            sum += start-request+duration;
            start += duration;
            } else{
            cur = req.poll();
            int request = cur[0];
            int duration = cur[1];
            sum += duration;
            start = request + duration;
            }
            
        }
        return sum/n;
    }
}