import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int size = want.length;

        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            wantMap.put(want[i], number[i]);
        }

        Map<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            countMap.put(discount[i], countMap.getOrDefault(discount[i], 0) + 1);
        }

        if (check(wantMap, countMap)) answer++;

        for (int start = 1; start <= discount.length - 10; start++) {
            String removeItem = discount[start - 1];
            String addItem = discount[start + 9];

            countMap.put(removeItem, countMap.get(removeItem) - 1);
            if (countMap.get(removeItem) == 0) {
                countMap.remove(removeItem);
            }

            countMap.put(addItem, countMap.getOrDefault(addItem, 0) + 1);

            if (check(wantMap, countMap)) answer++;
        }

        return answer;
    }

    private boolean check(Map<String, Integer> wantMap, Map<String, Integer> countMap) {
        for (String key : wantMap.keySet()) {
            if (countMap.getOrDefault(key, 0) < wantMap.get(key)) {
                return false;
            }
        }
        return true;
    }
}
