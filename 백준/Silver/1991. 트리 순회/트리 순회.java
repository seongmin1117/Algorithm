import java.util.*;

public class Main {
    static int n;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[26][2];
        sc.nextLine();
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int num = st.nextToken().charAt(0)-65;
            for(int j=0; j<2; j++) {
                arr[num][j] = st.nextToken().charAt(0) - 65;
            }
        }
        pre(0);
        System.out.println();
        in(0);
        System.out.println();
        post(0);
    }
    static void pre(int k){
        System.out.print((char)(k+65));
        int left =arr[k][0];
        int right=arr[k][1];
        if(left>0){
            pre(left);
        }
        if(right>0){
            pre(right);
        }
    }
    static void in(int k){
        int left = arr[k][0];
        int right = arr[k][1];
        if(left>0){
            in(left);
        }
        System.out.print((char) (k+65));
        if(right>0){
            in(right);
        }
    }
    static void post(int k){
        int left = arr[k][0];
        int right = arr[k][1];
        if(left>0){
            post(left);
        }
        if(right>0){
            post(right);
        }
        System.out.print((char)(k+65));
    }
}
