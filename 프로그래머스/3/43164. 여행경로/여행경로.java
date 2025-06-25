import java.util.*;

class Solution {
    boolean[] visited;
    String[] path;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        path = new String[tickets.length + 1];

        // 알파벳 순 정렬
        Arrays.sort(tickets, Comparator.comparing((String[] t) -> t[0]).thenComparing(t -> t[1]));

        path[0] = "ICN";
    
        return dfs("ICN", 1, tickets);
    }

    String[] dfs(String cur, int depth, String[][] tickets) {
        if (depth == tickets.length + 1) {
            return Arrays.copyOf(path, path.length);
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(cur)) {
                visited[i] = true;
                path[depth] = tickets[i][1];

                String[] result = dfs(tickets[i][1], depth + 1, tickets);
                if (result != null) return result;

                visited[i] = false;
            }
        }
        return null;
    }
}
