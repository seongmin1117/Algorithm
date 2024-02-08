import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 문자열을 문자 배열로 변환
        Character[] arr = new Character[input.length()];
        for (int i = 0; i < input.length(); i++) {
            arr[i] = input.charAt(i);
        }

        // 내림차순으로 정렬
        Arrays.sort(arr, new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                // 내림차순으로 정렬하기 위해 c2와 c1을 비교합니다.
                return c2.compareTo(c1);
            }
        });

        // 정렬된 문자 배열을 문자열로 변환하여 출력
        StringBuilder sb = new StringBuilder();
        for (Character c : arr) {
            sb.append(c);
        }
        System.out.println(sb.toString());

        br.close();
    }
}
