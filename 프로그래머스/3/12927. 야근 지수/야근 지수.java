import java.util.*;

class Solution {
    public long solution(int n, int[] w) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : w) q.add(x);

        while (n > 0) {
            n--;
            int x = q.poll();
            if (x == 0) break;
            q.add(x - 1);
        }

        long ans = 0;
        for (int x : q) {
            ans += (long) x * x;
        } 
        return ans;
    }
}
