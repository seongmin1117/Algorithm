public class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        int lMin = Integer.MAX_VALUE;
        int rMin = Integer.MAX_VALUE;

        for (int l = 0; l < n; l++) {
            int r = n-(l+1);
            lMin = Math.min(lMin, a[l]);
            rMin = Math.min(rMin, a[r]);

            leftMin[l] = lMin;
            rightMin[r] = rMin;
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
                cnt++;
            }
        }

        return cnt;
    }
}
