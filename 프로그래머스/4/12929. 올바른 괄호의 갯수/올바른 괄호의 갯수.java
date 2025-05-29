class Solution {
    public int solution(int n) {
        return bt(0, 0, n);
    }

    private int bt(int open, int close, int n) {
        if (open == n && close == n) {
            return 1;
        }

        int count = 0;

        if (open < n) {
            count += bt(open + 1, close, n);
        }

        if (close < open) {
            count += bt(open, close + 1, n);
        }

        return count;
    }
}