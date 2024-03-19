import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<List<Integer>> node = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i=0; i<100; i++){
            node.add(new ArrayList<>());
        }

        for (int i=0; i<n; i++){
            String[] s = scanner.nextLine().split(" ");
            int c = s[0].charAt(0) -65;
            int l = s[1].charAt(0) -65;
            int r = s[2].charAt(0) -65;
            if (l<0) l=99;
            if (r<0) r=99;
            node.get(c).add(l);
            node.get(c).add(r);
        }
        dfs1(0);
        System.out.println();
        dfs2(0);
        System.out.println();
        dfs3(0);

    }
    static void dfs1(int k){
        List<Integer> my = node.get(k);
        System.out.print((char) (k+65));
        if (my.get(0) != 99){
            dfs1(my.get(0));
        }
        if (my.get(1) != 99){
            dfs1(my.get(1));
        }
    }
    static void dfs2(int k){
        List<Integer> my = node.get(k);
        if (my.get(0) != 99){
            dfs2(my.get(0));
        }
        System.out.print((char) (k+65));
        if (my.get(1) != 99){
            dfs2(my.get(1));
        }
    }
    static void dfs3(int k){
        List<Integer> my = node.get(k);
        if (my.get(0) != 99){
            dfs3(my.get(0));
        }
        if (my.get(1) != 99){
            dfs3(my.get(1));
        }
        System.out.print((char) (k+65));
    }
}

