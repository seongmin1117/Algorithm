import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<String> words = new ArrayList<>();

        // 단어 입력 받기
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (!words.contains(word)) { // 중복되는 단어 제거
                words.add(word);
            }
        }

        // 단어 정렬
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2); // 길이가 같으면 사전 순으로 정렬
                } else {
                    return s1.length() - s2.length(); // 길이가 다르면 길이순으로 정렬
                }
            }
        });

        // 정렬된 단어 출력
        for (String word : words) {
            bw.write(word + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
