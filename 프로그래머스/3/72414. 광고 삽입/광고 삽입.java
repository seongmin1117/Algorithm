public class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSeconds = toSeconds(play_time);
        int advSeconds = toSeconds(adv_time);
        long[] times = new long[playSeconds + 2];

        for (String log : logs) {
            String[] parts = log.split("-");
            int start = toSeconds(parts[0]);
            int end = toSeconds(parts[1]);
            times[start] += 1;
            times[end] -= 1;
        }

        for (int i = 1; i <= playSeconds; i++) {
            times[i] += times[i - 1];
        }

        for (int i = 1; i <= playSeconds; i++) {
            times[i] += times[i - 1];
        }

        long maxView = times[advSeconds - 1];
        int startTime = 0;
        for (int i = advSeconds; i <= playSeconds; i++) {
            long view = times[i] - times[i - advSeconds];
            if (view > maxView) {
                maxView = view;
                startTime = i - advSeconds + 1;
            }
        }

        return toTimeString(startTime);
    }

    private int toSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 3600
             + Integer.parseInt(parts[1]) * 60
             + Integer.parseInt(parts[2]);
    }

    private String toTimeString(int seconds) {
        int h = seconds / 3600;
        seconds %= 3600;
        int m = seconds / 60;
        int s = seconds % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
