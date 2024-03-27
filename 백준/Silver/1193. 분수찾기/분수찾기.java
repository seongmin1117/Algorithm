import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 1;
        int y = 1;
        int temp = -1;
        boolean chk = false;
        for(int i=1; i<n; i++){
            if(x==1 && !chk){
                y++;
                chk =true;
                temp *= -1;
                continue;
            } else if(y==1 && !chk) {
                x++;
                chk=true;
                temp *=-1;
                continue;
            }
            chk = false;
            x += temp;
            y -= temp;



        }
        System.out.println(x+"/"+y);
    }

}
