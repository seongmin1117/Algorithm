import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {

        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int cur = Integer.MIN_VALUE;

        for (int[] route : routes) {
            int entry = route[0];
            int exit = route[1];

            if (cur < entry) {
                count++;
                cur = exit;
            }
        }

        return count;
    }
}
