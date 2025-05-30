import java.util.*;

public class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        List<Integer> crewTimes = new ArrayList<>();
        for (String time : timetable) {
            crewTimes.add(toMinutes(time));
        }

        Collections.sort(crewTimes);
        int busTime = toMinutes("09:00");
        int crewIndex = 0;

        int lastArrival = 0;

        for (int i=0; i<n; i++) {
            int capacity = m;
            while (capacity > 0 && crewIndex < crewTimes.size() && crewTimes.get(crewIndex) <= busTime) {
                crewIndex++;
                capacity--;
            }

            if (i == n-1) {
                
                if (capacity > 0) {
                    lastArrival = busTime;
                } else {
                    
                    lastArrival = crewTimes.get(crewIndex - 1) - 1;
                }
            }

            busTime += t;
        }

        return toTimeString(lastArrival);
    }

    private int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private String toTimeString(int minutes) {
        int h = minutes / 60;
        int m = minutes % 60;
        return String.format("%02d:%02d", h, m);
    }
}
