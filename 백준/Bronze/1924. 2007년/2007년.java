import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt(); int y= scanner.nextInt();
        int[] list = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        String[] day = {"SUN", "MON","TUE", "WED", "THU", "FRI", "SAT" };
        int date = y;
        for(int i =1; i<x; i++) {
            date += list[i];
        }
        int a = date%7;
        System.out.println(day[a]);
    }
}
