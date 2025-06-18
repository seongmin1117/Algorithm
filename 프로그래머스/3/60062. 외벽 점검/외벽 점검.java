import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        int len = weak.length;

        // 원형 → 선형
        int[] weakLine = new int[len * 2];
        for (int i = 0; i < len; i++) {
            weakLine[i] = weak[i];
            weakLine[i + len] = weak[i] + n;
        }

        // dist 배열 순열 생성
        permute(dist, 0, n, weak, weakLine);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    // 순열 생성
    void permute(int[] dist, int depth, int n, int[] weak, int[] weakLine) {
        if (depth == dist.length) {
            // 1명부터 최대 친구수까지 잘라서 탐색
            for (int friendCount = 1; friendCount <= dist.length; friendCount++) {
                if (check(dist, n, weak, weakLine, friendCount)) {
                    answer = Math.min(answer, friendCount);
                }
            }
            return;
        }

        for (int i = depth; i < dist.length; i++) {
            swap(dist, i, depth);
            permute(dist, depth + 1, n, weak, weakLine);
            swap(dist, i, depth);
        }
    }

    boolean check(int[] dist, int n, int[] weak, int[] weakLine, int friendCount) {
        int len = weak.length;

        for (int start = 0; start < len; start++) {
            int count = 1;
            int position = weakLine[start] + dist[0];

            for (int i = start + 1; i < start + len; i++) {
                if (weakLine[i] > position) {
                    count++;
                    if (count > friendCount) break;
                    position = weakLine[i] + dist[count - 1];
                }
            }

            if (count <= friendCount) return true;
        }

        return false;
    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
