import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.toUpperCase();

        int[] list = new int[26];

        for(int i=0; i<str.length(); i++ ) {
            char ch = str.charAt(i);
            list[ch-'A']++;
        }
        int max = 0;
        char result = '?';

        for(char ch='A'; ch<='Z'; ch++) {
            int count = list[ch-'A'];
            if(count>max) {
                max=count;
                result= ch;
            } else if( count == max) {
                result = '?';
            }
        }

        System.out.println(result);

    }

}