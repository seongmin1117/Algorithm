class Solution {
    public int solution(int[] s, int k) {
        int left = 1;
        int right = 200000000;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canCross(s, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean canCross(int[] s, int k, int n) {
        int skip = 0;
        for (int num : s) {
            if (num - n < 0) {
                skip++;
                if (skip >= k) return false;
            } else {
                skip = 0;
            }
        }
        return true;
    }
}
