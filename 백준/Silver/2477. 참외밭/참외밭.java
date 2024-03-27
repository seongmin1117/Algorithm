import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[6];
        int maxW = 0, maxH = 0;

        for (int i = 0; i < 6; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i] = y;

            if (x == 1 || x == 2)
                maxW = Math.max(maxW, y);
            else
                maxH = Math.max(maxH, y);
        }

        int ans = 0;
        for (int i = 0; i < 6; i++) {
            int nextIdx = (i + 1) % 6;
            int prevIdx = (i + 5) % 6;

            if ((arr[i] == maxW && arr[nextIdx] == maxH) || (arr[i] == maxH && arr[nextIdx] == maxW)) {
                ans = maxW * maxH - arr[(i + 3) % 6] * arr[(i + 4) % 6];
                break;
            }
        }

        System.out.println(ans * n);
    }
}
