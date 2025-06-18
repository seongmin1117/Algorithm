import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int wanhoSum = scores[0][0] + scores[0][1];
        int wanhoIndex = 0;

        for (int i = 1; i < scores.length; i++) {
            if (scores[i][0] > scores[0][0] && scores[i][1] > scores[0][1]) {
                return -1;
            }
        }

        List<int[]> indexed = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            indexed.add(new int[]{i, scores[i][0], scores[i][1]});
        }

        indexed.sort((a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[2], b[2]);
            return Integer.compare(b[1], a[1]);
        });

        int maxB = 0;
        List<int[]> candidates = new ArrayList<>();
        for (int[] s : indexed) {
            if (s[2] >= maxB) {
                candidates.add(new int[]{s[0], s[1] + s[2]}); 
                maxB = Math.max(maxB, s[2]);
            }
        }

        candidates.sort((a, b) -> Integer.compare(b[1], a[1]));

        int rank = 1;
        int prevSum = -1;
        int sameCount = 0;

        for (int[] s : candidates) {
            int index = s[0];
            int total = s[1];

            if (total != prevSum) {
                rank += sameCount;
                sameCount = 1;
                prevSum = total;
            } else {
                sameCount++;
            }

            if (index == wanhoIndex) return rank;
        }

        return -1;
    }
}
