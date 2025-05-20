public class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long l = 0;
        long r = 4L * (long) 1e14;
        long answer = r;

        int n = g.length;

        while (l<= r) {
            long mid = (l + r) / 2;

            long totalG = 0;
            long totalS = 0;
            long total = 0;

            for (int i = 0; i < n; i++) {
                long round = t[i] * 2L;
                long move = mid / round;
                if (mid % round >= t[i]) move++;

                long maxCarry = move * w[i];
                long gCarry = Math.min(g[i], maxCarry);
                long sCarry = Math.min(s[i], maxCarry);
                long sumCarry = Math.min(g[i] + s[i], maxCarry);

                totalG += gCarry;
                totalS += sCarry;
                total += sumCarry;
            }

            if (totalG >= a && totalS >= b && total >= a + b) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return answer;
    }
}
