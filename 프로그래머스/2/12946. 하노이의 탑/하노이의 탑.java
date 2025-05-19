import java.util.*;

class Solution {
    List<int[]> result;

    public int[][] solution(int n) {
        result = new ArrayList<>();
        move(n, 1, 3, 2); // n개의 원판을 1번 → 3번 (보조: 2번)
        return result.toArray(new int[result.size()][]);
    }

    private void move(int n, int from, int to, int temp) {
        if (n == 1) {
            result.add(new int[]{from, to});
            return;
        }

        move(n - 1, from, temp, to);      // 1. n-1개를 보조 기둥으로
        result.add(new int[]{from, to}); // 2. 가장 큰 원판을 목표 기둥으로
        move(n - 1, temp, to, from);      // 3. 보조 기둥에 있던 n-1개를 목표 기둥으로
    }
}