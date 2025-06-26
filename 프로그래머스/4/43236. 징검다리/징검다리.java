import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int l = 1;
        int r = distance;
        int answer = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            int removed = 0;
            int prev = 0;

            for (int rock : rocks) {
                if (rock - prev < mid) {
                    removed++;
                } else {
                    prev = rock;
                }
            }

            if (distance - prev < mid) {
                removed++;
            }

            if (removed <= n) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return answer;
    }
}
