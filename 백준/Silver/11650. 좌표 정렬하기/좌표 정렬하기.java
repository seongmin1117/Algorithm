import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[][] points = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }
        
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });
        
        for (int i = 0; i < n; i++) {
            System.out.println(points[i][0] + " " + points[i][1]);
        }
        
        scanner.close();
    }
}
