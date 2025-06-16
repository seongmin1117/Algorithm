class Solution {
    public int solution(int n, int[] stations, int w) {
        int count = 0;
        int range = 2 * w + 1;
        int pos = 1;

        for (int s : stations) {
            int left = s - w;

            if (pos < left) {
                int gap = left - pos;
                count += (gap + range - 1) / range;
            }

            pos = s + w + 1;
        }

        if (pos <= n) {
            int gap = n - pos + 1;
            count += (gap + range - 1) / range;
        }

        return count;
    }
}
