import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        int n = food_times.length;
        
        long total = 0;
        for (int time : food_times) {
            total += time;
        }
        if (total <= k) {
            return -1;
        }

        List<Food> foods = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            foods.add(new Food(food_times[i-1], i));
        }

        foods.sort(Comparator.comparingInt(f -> f.time));

        long prev = 0;
        int i = 0;
        
        while (i < n) {
            
            long diff = foods.get(i).time - prev;
            
            if (diff != 0) {
                long spend = diff * (n - i);
                if (spend <= k) {
                    k -= spend;
                    prev = foods.get(i).time;
                    continue;
                }
                break;
            }
            i++;
        }

        List<Food> remaining = foods.subList(i, n);
        remaining.sort(Comparator.comparingInt(f -> f.index));

        return remaining.get((int)(k % remaining.size())).index;
    }

    static class Food {
        int time;
        int index;

        Food(int time, int index) {
            this.time = time;
            this.index = index;
        }
    }
}
