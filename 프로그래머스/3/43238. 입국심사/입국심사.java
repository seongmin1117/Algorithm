import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long) 1_000_000_000 * n;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int t : times) {
                count += mid / t;
            }

            if (count >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
