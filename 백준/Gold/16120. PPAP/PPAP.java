import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    PPAP

    P는 PPAP 문자열이다
    PPAP 문자열에서 P 하나를 PPAP로 바꾼 문자열은 PPAP이다.
    ex) PPPAPAP 도 PPAP

    오토마타그래프로 풀어보자 !
     */
    static int count =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int state = 0;
        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
//            System.out.println(state+" "+ch);
            state = getState(state,ch);
            if (state ==-1){
                break;
            }
        }
        //실패
        if (state==3 || state ==-1 ||state ==2){
            System.out.println("NP");
        }//성공
        else {
            System.out.println("PPAP");
        }
    }
    static int getState(int state, char ch){
        if (ch =='P'){
            count++;
            switch (state){
                case 0:
                    return 1;
                case 1:
                    return 2;
                case 2:
                    return 2;
                case 3:
                    return 4;
                case 4:
                    if (count>1) return 2;
                    return 1;
            }
        }
        if (ch =='A'){
            count-=2;
            if (count<0) return -1;
            switch (state){
                case 2:
                    return 3;
                case 4:
                    return 3;
            }
        }
        return -1;
    }
}
